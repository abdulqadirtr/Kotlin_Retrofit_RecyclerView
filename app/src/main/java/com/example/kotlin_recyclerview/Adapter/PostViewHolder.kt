package com.example.kotlin_recyclerview.Adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.R

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txt_title: TextView
    var txt_content: TextView
    var txt_author: TextView

    init {
        txt_title = itemView.findViewById<View>(R.id.txt_title) as TextView
        txt_content = itemView.findViewById<View>(R.id.txt_content) as TextView
        txt_author = itemView.findViewById<View>(R.id.txt_author) as TextView
    }
}