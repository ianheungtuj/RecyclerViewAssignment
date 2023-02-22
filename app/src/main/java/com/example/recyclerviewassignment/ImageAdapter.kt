package com.example.recyclerviewassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

// We created a class inside a class here. ImageViewHolder holds the images,
// and ImageAdapter holds ImageviewHolders


// We require ImageAdapter to have to take in an array of integers as the parameters
class ImageAdapter(_imageItems : Array<ImageItem>, _callback : (ImageItem)->Unit) : RecyclerView.Adapter<ImageAdapter.ImageItemViewHolder>()
{
    private val imageItems = _imageItems
    private val callback = _callback

    // What is an inner class?
    // If there is a normal class inside ImageAdapter, it cannot access things outside of ImageAdapter
    // But inner classes have direct access to anything ImageAdapter has access to
    inner class ImageItemViewHolder(layout : View) : RecyclerView.ViewHolder(layout){
        val imageView = layout.findViewById<ImageView>(R.id.imageView)
        val textView = layout.findViewById<TextView>(R.id.textView)

        // An init block is like a secondary constructor
        init {
            imageView.setOnClickListener{callback(imageItems[adapterPosition])}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        // LayoutInflater
        return ImageItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.imageView.setImageResource(imageItems[position].id)
        holder.textView.text = imageItems[position].name
    }

    override fun getItemCount(): Int {
        return imageItems.size
    }
}