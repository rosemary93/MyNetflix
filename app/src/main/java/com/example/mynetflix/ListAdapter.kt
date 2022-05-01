package com.example.mynetflix

import android.R.layout
import android.R.id
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynetflix.database.Film


class ListAdapter(var dataset:List<Film>):RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
lateinit var buttonListener:onButtonClickListener

interface onButtonClickListener{
    fun onButtonClick(position: Int)
}


    fun setOnButtonClickListener(listener:onButtonClickListener){
        buttonListener=listener
    }

inner class ListViewHolder(itemview: View,listener:onButtonClickListener):RecyclerView.ViewHolder(itemview){
    val filmImage=itemview.findViewById<ImageView>(R.id.imageView_film1)
    val filmNAme=itemview.findViewById<TextView>(R.id.textView_film_name1)
    val isFavoriteBtn=itemview.findViewById<Button>(R.id.button_favorite1)

    init {

        isFavoriteBtn.setOnClickListener {
            listener.onButtonClick(adapterPosition)
            if (dataset[adapterPosition].isFavorite)
            {
                isFavoriteBtn.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    R.drawable.ic_baseline_favorite_red_24,
                    0,
                    0
                )
            }else{
                isFavoriteBtn.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    R.drawable.ic_baseline_favorite_24,
                    0,
                    0
                )
            }

        }
    }
}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view,buttonListener)
    }



    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        if (dataset[position].isFavorite)
        {
            holder.isFavoriteBtn.setCompoundDrawablesWithIntrinsicBounds(
                0,
                R.drawable.ic_baseline_favorite_red_24,
                0,
                0
            )
        }
        holder.filmNAme.text=dataset[position].title
        holder.filmImage.setImageResource(dataset[position].imageID)

    }

    override fun getItemCount(): Int =dataset.size
}