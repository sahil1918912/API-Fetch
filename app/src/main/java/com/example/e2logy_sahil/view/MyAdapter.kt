package com.example.e2logy_sahil.view

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e2logy_sahil.R
import com.example.e2logy_sahil.model.Result

class MyAdapter(private val context: Context, private val list: List<Result>, private val itemClickListener: (Result) -> Unit) : RecyclerView.Adapter<MyAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img = v.findViewById<ImageView>(R.id.rvImage)
        val title = v.findViewById<TextView>(R.id.rvTitle)
        val description = v.findViewById<TextView>(R.id.rvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val result = list[position]
        Glide.with(context)
            .load(result.Image)
            .error(R.drawable.baseline_close_24)
            .into(holder.img)
        holder.title.text = result.Title
        holder.description.text = result.Description

        if (result.Description.length > 100) {
            holder.description.text = result.Description.substring(0, 100) + "..."
        }
        if (result.Title.length > 60) {
            holder.title.text = result.Description.substring(0, 50) + "..."
        }

        holder.itemView.setOnClickListener {
                itemClickListener(result)
        }
    }
}
