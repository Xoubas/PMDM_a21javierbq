package com.example.ud2_5_images

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ou = findViewById<ImageView>(R.id.ou)
        val ouDesc = findViewById<TextView>(R.id.ouDesc)
        val san = findViewById<ImageView>(R.id.san)
        val sanDesc = findViewById<TextView>(R.id.sanDesc)

        ou.setOnClickListener {
            if ((ouDesc.text).equals(""))
                ouDesc.text = "Esta é a miña cidade"
            else
                ouDesc.text = ""
        }

        san.setOnClickListener {
            if ((ouDesc.text).equals(""))
                sanDesc.text = "Cidade do mollatontos"
            else
                sanDesc.text = ""
        }
    }
}