package com.example.mynetflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(var dataset:List<Film>):RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


class ListViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
    val filmImage=itemview.findViewById<ImageView>(R.id.imageView_film)
    val filmNAme=itemview.findViewById<TextView>(R.id.textView_film_name)
    val isFavoriteBtn=itemview.findViewById<Button>(R.id.button_favorite)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.filmNAme.text=dataset[position].title
        holder.filmImage.setImageResource(dataset[position].imageID)
        if (dataset[position].isFavorite)
        {
            holder.isFavoriteBtn.setCompoundDrawablesWithIntrinsicBounds(
                0,
                R.drawable.ic_baseline_favorite_red_24,
                0,
                0
            )
        }
    }

    override fun getItemCount(): Int =dataset.size
}