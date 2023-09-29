package com.example.ud1_3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    lateinit var chrono: Chronometer
    var running = false
    var offset = 0L
    val RUNNING_KEY = "running"
    val OFFSET_KEY = "offset"
    val BASE_KEY = "base"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chrono = findViewById(R.id.chrn)

        if (savedInstanceState != null) {
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            chrono.base = savedInstanceState.getLong(BASE_KEY)
            if (running) {
                chrono.base = savedInstanceState.getLong(BASE_KEY)
                chrono.start()
            } else {
                chrono.base = SystemClock.elapsedRealtime() - offset
            }
        }

        //Chronometer buttons:
        //Finds the button by id in the xml file
        val btnStart = findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener() {
            if (!running) {
                chrono.base = SystemClock.elapsedRealtime() - offset
                chrono.start()
                running = true
            }
        }

        val btnPause = findViewById<Button>(R.id.btn_pause)
        btnPause.setOnClickListener() {
            if (running) {
                offset = SystemClock.elapsedRealtime() - chrono.base
                chrono.stop()
                running = false
            }
        }

        val btnRest = findViewById<Button>(R.id.btn_restart)
        btnRest.setOnClickListener() {
            offset = 0
            chrono.base = SystemClock.elapsedRealtime()
        }
    }

    //Function to save the app's state when tilting the screen
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY, running)
        outState.putLong(OFFSET_KEY, offset)
        outState.putLong(BASE_KEY, chrono.base)
        super.onSaveInstanceState(outState)
    }

    //Functions to stop and restart the app when losing focus
    override fun onStop() {
        stopChrono()
        super.onStop()
    }

    override fun onRestart() {
        startChrono()
        super.onRestart()
    }

    override fun onPause() {
        stopChrono()
        super.onPause()
    }

    override fun onResume() {
        startChrono()
        super.onResume()
    }

    fun startChrono() {
        if (running) {
            chrono.base = SystemClock.elapsedRealtime() - offset
            chrono.start()
        }
    }

    fun stopChrono() {
        if (running) {
            offset = SystemClock.elapsedRealtime() - chrono.base
            chrono.stop()
        }
    }
}