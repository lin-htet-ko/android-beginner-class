package com.linhtetko.demo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class BlogViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val image = view.findViewById<ImageView>(R.id.ivVhBlog)
    private val title = view.findViewById<TextView>(R.id.tvVhBlogTitle)
    private val content = view.findViewById<TextView>(R.id.tvVhBlogContent)

    fun bind(blogItem: BlogItem){
        image.setImageResource(blogItem.img)
        title.text = blogItem.title
        content.text = blogItem.content
    }
}