package com.linhtetko.demo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BlogAdapter(
    private var blogs: List<BlogItem>
): RecyclerView.Adapter<BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_blog, parent, false)
        return BlogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return blogs.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(blogs[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(items: List<BlogItem>){
        blogs = items
        notifyDataSetChanged()
    }
}