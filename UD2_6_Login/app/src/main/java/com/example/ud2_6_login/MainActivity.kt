package com.example.ud2_6_login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = findViewById<EditText>(R.id.user)
        val pass = findViewById<EditText>(R.id.password)
        val button = findViewById<Button>(R.id.button)
        val result = findViewById<TextView>(R.id.info)

        button.setOnClickListener {
            if ((result.text).equals(""))
                result.text = "User: " + user.getText() + " / Pasword: " + pass.getText()
            else
                result.text = ""
        }
    }
}