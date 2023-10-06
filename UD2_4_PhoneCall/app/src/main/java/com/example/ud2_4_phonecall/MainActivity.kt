package com.example.ud2_4_phonecall

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val llamar =findViewById<Button>(R.id.but)
        val textLamar = findViewById<TextView>(R.id.showCall)

        llamar.setOnClickListener{
            textLamar.text="CALLING"
        }
    }
}