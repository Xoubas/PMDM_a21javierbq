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

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
}

class MovieAdapter(
    private var dataset: List<Movie>,
    private val context: Context,
    private val itemClickListener: HomeFragment
) : RecyclerView.Adapter<MovieAdapter.MovieAdapterHolder>() {

    class MovieAdapterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.movie_poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MovieAdapterHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MovieAdapterHolder, position: Int) {
        // Load image using Picasso
        Picasso.get().load(dataset[position].poster).into(holder.imageView)

        // Set click listener for each poster
        holder.imageView.setOnClickListener {
            itemClickListener.movieClick(dataset[position])
        }
    }

    override fun getItemCount() = dataset.size

    fun setDataset(movieList: List<Movie>) {
        dataset = movieList
        notifyDataSetChanged()
    }
}

