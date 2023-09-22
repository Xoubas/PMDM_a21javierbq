package com.example.ud1_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonSearch = findViewById<Button>(R.id.button)
        buttonSearch.setOnClickListener {
            val spinnerWineTypes = findViewById<Spinner>(R.id.wineType)
            val textWines = findViewById<TextView>(R.id.textWines)
            textWines.text = getWines(spinnerWineTypes.selectedItemId).joinToString(" ")
        }
    }
    fun getWines(id: Long): List<String> = when (id) {
        0L -> listOf("Albariño", "Moscato", "Verdejo")
        1L -> listOf("Rioja", "Ribera del Duero", "Toro")
        2L -> listOf("Cabernet", "Franc", "Merlot")
        else -> listOf()
    }
}