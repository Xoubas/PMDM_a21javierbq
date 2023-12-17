package com.example.pmdm_project.model

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

class MovieTypeAdapter : TypeAdapter<Movie>() {
    override fun write(writer: JsonWriter, value: Movie?) {
        TODO("Not yet implemented")
    }

    override fun read(reader: JsonReader): Movie? {
        var title: String? = null
        var runtime: String? = null
        var genres: LinkedHashSet<String>? = LinkedHashSet()
        var director: String? = null
        var actors: String? = null
        var plot: String? = null
        var poster: String? = null

        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        }

        reader.beginObject()
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        }
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "Title" -> title = reader.nextString()
                "Runtime" -> runtime = hoursMinutes(reader.nextString())
                "Genre" -> genres = divideGenres(reader.nextString())
                "Director" -> director = reader.nextString()
                "Actors" -> actors = reader.nextString()
                "Plot" -> plot = reader.nextString()
                "Poster" -> poster = reader.nextString()
                else -> reader.skipValue()
            }
        }

        reader.endObject()

        return Movie(title, runtime, genres, director, actors, plot, poster)
    }

    private fun hoursMinutes(timeString: String): String {
        val minutesString: String = timeString.replace(Regex("[^\\d]"), "")
        val time: Int = minutesString.toInt()

        val hours: Int
        val minutes: Int
        if (time >= 60) {
            hours = time / 60
            minutes = time.mod(60)
            return if (minutes == 0) {
                if (hours != 1) {
                    "$hours hours"
                } else {
                    "$hours hours"
                }
            } else {
                if (hours != 1 && minutes != 1) {
                    "$hours hours $minutes minutes"
                } else if (hours != 1) {
                    "$hours hours $minutes minute"
                } else {
                    "$hours hour $minutes minutes"
                }
            }
        } else {
            minutes = time.mod(60)
            return "$minutes minutes"
        }
    }

    private fun divideGenres(genres: String): LinkedHashSet<String> {
        val sepGenres: List<String> = genres.split(", ")

        return LinkedHashSet(sepGenres)
    }
}