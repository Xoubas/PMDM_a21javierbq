package com.example.pmdm_project.model
import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val title: String?,
    val runtime: String?,
    val genres: LinkedHashSet<String>?,
    val director: String?,
    val actors: String?,
    val plot: String?,
    val poster: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        LinkedHashSet(parcel.createStringArrayList()),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(runtime)
        parcel.writeStringList(genres?.toList()) // Convert LinkedHashSet to List before writing
        parcel.writeString(director)
        parcel.writeString(actors)
        parcel.writeString(plot)
        parcel.writeString(poster)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}
