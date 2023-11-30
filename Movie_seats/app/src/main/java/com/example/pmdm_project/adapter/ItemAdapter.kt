package com.example.pmdm_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pmdm_project.R
import com.example.pmdm_project.databinding.FragmentHomeBinding
import com.example.pmdm_project.databinding.ListItemBinding
import com.example.pmdm_project.model.Movie
import com.example.pmdm_project.model.RecyclerEvent


class ItemAdapter(
    private val dataset: List<String>,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
//    private var onClickListener: OnClickListener? = null

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.movie_title)
    }

    //When the viewHolder is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = dataset[position]
//        holder.itemView.setOnClickListener {
//            if (onClickListener != null) {
//                onClickListener!!.onClick(position, item)
//            }
//        }
    }

//    fun setOnClickListener(onClickListener: OnClickListener) {
//        this.onClickListener = onClickListener
//    }

//    interface OnClickListener {
//        fun onClick(position: Int, model: Employee)
//    }

    //Size of the list
    override fun getItemCount() = dataset.size
}
