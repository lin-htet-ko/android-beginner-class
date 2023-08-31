package com.linhtetko.demo

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlin.math.roundToInt

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var etCost: AppCompatEditText
    private lateinit var rgServices: RadioGroup
    private lateinit var rbServiceAmazing: AppCompatRadioButton
    private lateinit var rbServiceGood: AppCompatRadioButton
    private lateinit var rbServiceOk: AppCompatRadioButton
    private lateinit var scRound: SwitchCompat
    private lateinit var btnCalculate: AppCompatButton
    private lateinit var tvTotal: AppCompatTextView

    private var servicePercentage: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCost = findViewById(R.id.etMainRestaurant)
        rgServices = findViewById(R.id.rgMainService)
        rbServiceAmazing = findViewById(R.id.rbMainService20)
        rbServiceGood = findViewById(R.id.rbMainService18)
        rbServiceOk = findViewById(R.id.rbMainService15)
        scRound = findViewById(R.id.scMainRound)
        btnCalculate = findViewById(R.id.btnMainCalculate)
        tvTotal = findViewById(R.id.tvMainTotal)

        servicePercentage = getTipPercentage(rgServices.checkedRadioButtonId)

        rgServices.setOnCheckedChangeListener { _, checkedId ->
            servicePercentage = getTipPercentage(checkedId)
        }

        btnCalculate.setOnClickListener {

            val cost = etCost.text

            if (!cost.isNullOrBlank()){
                val tip = cost.toString().toInt() * servicePercentage
                val result = if (scRound.isChecked) tip.roundToInt() else tip

                tvTotal.text = "Total Cost : $result \$"
            }
        }
    }


    private fun getTipPercentage(checkedId: Int) = when(checkedId){
        R.id.rbMainService20 -> 0.2
        R.id.rbMainService18 -> 0.18
        R.id.rbMainService15 -> 0.15
        else -> 0.0
    }

}