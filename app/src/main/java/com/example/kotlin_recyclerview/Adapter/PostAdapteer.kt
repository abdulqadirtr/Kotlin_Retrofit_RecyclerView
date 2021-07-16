package com.example.kotlin_recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Model.Post
import com.example.kotlin_recyclerview.R
import retrofit2.Response

class PostAdapteer(
    var postList: List<Post?>?
) : RecyclerView.Adapter<PostAdapteer.PostViewHolder>() {

    private val items : MutableList<Post?> = mutableListOf()
    var itemClickListener : (Post?, Boolean) -> Unit = {Post , status -> }

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

   inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_title: TextView
        var txt_content: TextView
        var txt_author: TextView

        init {

            txt_title = itemView.findViewById<View>(R.id.txt_title) as TextView
            txt_content = itemView.findViewById<View>(R.id.txt_content) as TextView
            txt_author = itemView.findViewById<View>(R.id.txt_author) as TextView

            itemView.setOnClickListener {
                itemClickListener.invoke(postList!![adapterPosition] , true)
            }
        }
    }
}