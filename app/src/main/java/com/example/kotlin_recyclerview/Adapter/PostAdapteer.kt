package com.example.kotlin_recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Model.Post
import com.example.kotlin_recyclerview.R
import retrofit2.Response

class PostAdapteer(
    var postList: List<Post?>?
) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.txt_title.text = postList?.get(position)?.title.toString()
        holder.txt_content.text = StringBuilder(postList!!.get(position)?.body!!.substring(0, 2))
            .append("...").toString()
    }

    override fun getItemCount(): Int {
        return postList!!.size
    }

}