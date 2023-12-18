package com.example.pmdm_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmdm_project.R
import com.example.pmdm_project.model.Movie
import com.example.pmdm_project.view.HomeFragment
import com.squareup.picasso.Picasso
class MovieAdapter(
    private var dataset: List<Movie>,
    private val context: Context,
    private val itemClickListener: HomeFragment
) : RecyclerView.Adapter<MovieAdapter.MovieAdapterHolder>() {

    class MovieAdapterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.movie_poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MovieAdapterHolder(adapterLayout)
    }

    /*
    Esta es la función que va a ir colocando en cada ViewHolder del
    RecyclerView las imagenes de las películas sacadas de la api
     */
    override fun onBindViewHolder(holder: MovieAdapterHolder, position: Int) {
        //Cargar imagen con piccaso en HomeFragment
        Picasso.get().load(dataset[position].poster).into(holder.imageView)

        // Set click listener for each poster
        holder.imageView.setOnClickListener {
            itemClickListener.movieClick(dataset[position])
        }
    }

    //Obtener el numero de películas pasadas al recycler
    override fun getItemCount() = dataset.size

    fun setDataset(movieList: List<Movie>) {
        dataset = movieList
        notifyDataSetChanged()
    }
}

