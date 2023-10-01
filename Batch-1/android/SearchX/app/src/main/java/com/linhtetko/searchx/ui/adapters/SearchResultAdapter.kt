package com.linhtetko.searchx.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.linhtetko.searchx.R
import com.linhtetko.searchx.model.vos.SearchResultVO

class SearchResultAdapter(private var items: List<SearchResultVO> = emptyList()) :
    Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    class SearchResultViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val ivSearch = view.findViewById<ImageView>(R.id.ivLinearSearchItem)
        val tvSearch = view.findViewById<TextView>(R.id.tvLinearSearchItem)

        fun bind(item: SearchResultVO) {
            Glide.with(view.context).load(item.img).into(ivSearch)
            tvSearch.text = item.keywords
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_linear_search_item, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewItems(list: List<SearchResultVO>) {
        items = list
        notifyDataSetChanged()
    }
}