package com.example.generationfinder

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtYear  = findViewById<EditText>(R.id.edtYear)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        Log.d("", "Generations app loaded")

        btnCheck.setOnClickListener {
            val year = edtYear.text.toString().toIntOrNull()

            if (year == null) {
                tvResult.text = "Please enter a valid year!"
                Log.d("", "Invalid year input")
                return@setOnClickListener
            }

            Log.d("", "Year entered: $year")

            // Use when with ranges to determine generation
            val generation = when (year) {
                in 1928..1945 -> "Silent Generation"
                in 1946..1964 -> "Baby Boomer"
                in 1965..1980 -> "Generation X"
                in 1981..1996 -> "Millennial"
                in 1997..2012 -> "Generation Z"
                in 2013..2025 -> "Generation Alpha"
                else          -> "Year out of range!"
            }

            tvResult.text = "$year? $generation!"
            Log.d("", "Generation result: $generation")
        }
    }
}