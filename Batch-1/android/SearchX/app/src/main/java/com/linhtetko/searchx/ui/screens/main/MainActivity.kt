package com.linhtetko.searchx.ui.screens.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.linhtetko.searchx.R
import com.linhtetko.searchx.ui.adapters.SearchResultAdapter

class MainActivity : AppCompatActivity() {

    private var searchResultAdapter: SearchResultAdapter? = null
    private lateinit var rvResults: RecyclerView
    private lateinit var tvResult: TextView
    private lateinit var etSearch: TextInputEditText
    private lateinit var tilSearch: TextInputLayout
    private lateinit var pbMain: ProgressBar
    private lateinit var btnLayout: MaterialButton
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewModel()
        setUpViews()
        setUpAdapter()
        setUpListener()
        observeData()
    }

    private fun observeData() {
        viewModel.searchResult.observe(this){
            if(it != null){
                pbMain.visibility = View.GONE
                searchResultAdapter?.setNewItems(it)
                tvResult.text =
                    getString(R.string.lbl_s_search_results_found, it.size.toString())
            }
        }

        viewModel.error.observe(this){
            if(it != null){
                pbMain.visibility = View.GONE
                Toast.makeText(
                    this@MainActivity,
                    it,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        viewModel.loading.observe(this){
            if (it != null){
                if (it){
                    pbMain.visibility = View.VISIBLE
                }else{
                    pbMain.visibility = View.GONE
                }
            }
        }
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun setUpListener() {
        tilSearch.setEndIconOnClickListener {
            searchImage()
        }

        val sharePreference = getSharedPreferences("app-preference", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharePreference.edit()

        btnLayout.setOnClickListener {
            val isGrid = sharePreference.getBoolean("isGrid", false)
            if (!isGrid) {
                rvResults.layoutManager = GridLayoutManager(this, 2)
                btnLayout.setIconResource(R.drawable.ic_baseline_grid_view_24)
                editor.putBoolean("isGrid", true).apply()
            } else {
                rvResults.layoutManager = LinearLayoutManager(this)
                btnLayout.setIconResource(R.drawable.ic_baseline_list_alt_24)
                editor.putBoolean("isGrid", false).apply()
            }
        }
    }

    private fun searchImage() {
        val keyword = etSearch.text

        if (keyword.isNullOrEmpty()) {
            Toast.makeText(this, "Search Keyword is required", Toast.LENGTH_LONG).show()
            return
        }

        viewModel.searchImage(
            keyword = keyword.toString()
        )
    }

    private fun setUpViews() {
        rvResults = findViewById(R.id.rvMainImgs)
        tvResult = findViewById(R.id.tvMainResultCount)
        etSearch = findViewById(R.id.etMainSearch)
        tilSearch = findViewById(R.id.tilMainSearch)
        pbMain = findViewById(R.id.pbMain)
        btnLayout = findViewById(R.id.btnMainLayout)

        tvResult.text =
            getString(R.string.lbl_s_search_results_found, "0")
    }

    private fun setUpAdapter() {
        searchResultAdapter = SearchResultAdapter()
        rvResults.adapter = searchResultAdapter
    }
}