package com.hobodobo.buylist.grocery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hobodobo.buylist.R

class GroceryAdapter : RecyclerView.Adapter<GroceryAdapter.ViewHolder>(){
    var items: MutableList<Grocery> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.grocery_row, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleView.text = item.title
    }

    override fun getItemCount(): Int = items.count()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val titleView: TextView = view.findViewById(R.id.txt_grocery_title)
    }
}