package com.example.pmdm_project.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieAPI {
    @GET
    suspend fun getMovies(@Url url: String): Response<Movie>
}
