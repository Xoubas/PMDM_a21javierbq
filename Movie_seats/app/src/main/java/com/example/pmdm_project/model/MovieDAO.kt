package com.example.pmdm_project.model

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class MovieDAO {

    fun getMovie(url: URL): Movie {
        val gson: Gson = GsonBuilder().setPrettyPrinting()
            .serializeNulls().registerTypeAdapter(Movie::class.java, MovieTypeAdapter()).create()

        val br: BufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        return gson.fromJson(br, Movie::class.java)
    }
}