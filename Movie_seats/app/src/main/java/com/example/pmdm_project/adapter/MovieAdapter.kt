package com.example.pmdm_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmdm_project.R
import com.example.pmdm_project.model.Movie


class MovieAdapter(private var dataset: List<Movie>, private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.MovieAdapterHolder>() {
//    private var onClickListener: OnClickListener? = null

    class MovieAdapterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.movie_title)
    }

    //When the viewHolder is created
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
        val item = dataset[position]
        holder.textView.text = dataset[position].director
//        holder.itemView.setOnClickListener {
//            if (onClickListener != null) {
//                onClickListener!!.onClick(position, item)
//            }
//        }
    }

    override fun getItemCount() = dataset.size

    fun setDataset(movieList: List<Movie>) {
        dataset = movieList
        notifyDataSetChanged()
    }

    //    fun setOnClickListener(onClickListener: OnClickListener) {
//        this.onClickListener = onClickListener
//    interface OnClickListener {
//        fun onClick(position: Int, model: Employee)
//Size of the list


//    }

//    }
}
