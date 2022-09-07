package com.example.kotlin_recyclerview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Adapter.PostAdapter.PostViewHolder
import com.example.kotlin_recyclerview.Model.PostResponse
import com.example.kotlin_recyclerview.R

class PostAdapter: ListAdapter<PostResponse, PostViewHolder>(PostsDiffUtils()) {

    private val postResponseValue : MutableList<PostResponse> = mutableListOf()
    var itemClickListener : (PostResponse?, Boolean) -> Unit = { Post, status -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postResponseValue[position])
        holder.txt_title.text = getItem(position)?.title.toString()
        holder.txt_content.text = StringBuilder(getItem(position)?.body!!.substring(0, 2))
            .append("...").toString()

    }

   inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var txt_title = itemView.findViewById<View>(R.id.txt_title) as TextView
       var txt_content = itemView.findViewById<View>(R.id.txt_content) as TextView

       fun bind(item: PostResponse) {
           txt_title.text = item.title
           txt_content.text = StringBuilder(item.body!!.substring(0, 2))
                   .append("...").toString()
           itemView.setOnClickListener {
               itemClickListener.invoke(postResponseValue!![adapterPosition] , true)
           }
       }
    }

    class PostsDiffUtils : DiffUtil.ItemCallback<PostResponse>(){
        override fun areItemsTheSame(oldItem: PostResponse, newItem: PostResponse): Boolean {
            return (oldItem.id == newItem.id)
        }

        override fun areContentsTheSame(oldItem: PostResponse, newItem: PostResponse): Boolean {
            return (oldItem == newItem)
        }

    }
}