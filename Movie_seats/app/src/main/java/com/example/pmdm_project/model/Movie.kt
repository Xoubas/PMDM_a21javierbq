package com.example.pmdm_project.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title") val title: String?,
    @SerializedName("Runtime") val runtime: String?,
    @SerializedName("Genre") val genres: LinkedHashSet<Genre>?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Actors") val actors: String?,
    @SerializedName("Plot") val plot: String?,
    @SerializedName("Poster") val poster: String?,
    @SerializedName("Ratings") val ratings: ArrayList<Rating>?
)