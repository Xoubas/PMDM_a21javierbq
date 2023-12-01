package com.example.pmdm_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdm_project.adapter.ItemAdapter
import com.example.pmdm_project.databinding.ActivityMainBinding
import com.example.pmdm_project.model.Movie
import com.example.pmdm_project.model.MovieDAO
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}