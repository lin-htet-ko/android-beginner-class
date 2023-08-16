package com.linhtetko.demo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/*
    1 - Activity - UserInterface
    2 - BroadcastReceiver
    3 - Services
    4 - Content Provider
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View -> ViewGroup -> View, View, View
    }

    fun clickMeClick(view: View) {
        Toast.makeText(this, "User click button!", Toast.LENGTH_LONG).show()
    }
}