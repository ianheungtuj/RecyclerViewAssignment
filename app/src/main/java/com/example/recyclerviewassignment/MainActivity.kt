package com.example.recyclerviewassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val displayImageView = findViewById<ImageView>(R.id.displayImageView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)

        // Our data is an array of the images we inserted, but since they are already numbered,
        // we can just use an array of integers instead

        val images = arrayOf(
            ImageItem(R.drawable.android_01, "Lake"),
            ImageItem(R.drawable.android_02, "Daisies"),
            ImageItem(R.drawable.android_03, "Car lights"),
            ImageItem(R.drawable.android_04, "RV trailer"),
            ImageItem(R.drawable.android_05, "Seaside road"),
            ImageItem(R.drawable.android_06, "Autumn leaves"),
            ImageItem(R.drawable.android_07, "Colorful houses"),
            ImageItem(R.drawable.android_08, "Road")
        )

        val callback = { item: ImageItem ->
            displayImageView.setImageResource(item.id)
            nameTextView.text = item.name
        }

        recyclerView.adapter = ImageAdapter(images, callback)

        // Add a layout manager, which requires a context, this (main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}