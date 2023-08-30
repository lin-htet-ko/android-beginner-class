package com.linhtetko.demo

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWord = findViewById<AppCompatEditText>(R.id.etWord)
        val btnCheck = findViewById<AppCompatButton>(R.id.btnCheck)
        val tvResult = findViewById<AppCompatTextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val word = etWord.text.toString()

            if (word == word.reversed()){
                tvResult.text = "Your Win"
            }else{
                tvResult.text = "Your Fail"
            }
        }
    }


}