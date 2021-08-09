package com.example.kotlin_recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Model.Email
import com.example.kotlin_recyclerview.Model.Post
import com.example.kotlin_recyclerview.R
import retrofit2.Response

class PostAdapteer(
        var postList: ArrayList<Email>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private val items: MutableList<Post?> = mutableListOf()
    var itemClickListener: (Email?, Boolean) -> Unit = { Email, status -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        return when (viewType) {
            VIEW_TYPE_ONE -> {
                PostViewHolder(
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.post_layout, parent, false)                )
            }
            else -> {
                EmailViewHolder(
                        LayoutInflater.from(parent.context)
                        .inflate(R.layout.activity_email, parent, false))
            }
                   }
    }


    override fun getItemViewType(position: Int): Int {
        return postList[position].viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (postList[position].viewType === VIEW_TYPE_ONE) {
            (holder as PostViewHolder).bind(position)
        } else {
            (holder as EmailViewHolder).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return postList!!.size
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            var txt_title: TextView
            var txt_content: TextView
            var txt_author: TextView

            txt_title = itemView.findViewById<View>(R.id.txt_title) as TextView
            txt_content = itemView.findViewById<View>(R.id.txt_content) as TextView
            txt_author = itemView.findViewById<View>(R.id.txt_author) as TextView

            txt_title.text = postList[position].emailAddress

            /* itemView.setOnClickListener {
                 itemClickListener.invoke(postList!![adapterPosition] , true)
             }*/
        }
    }

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(position: Int) {

            var txt_title = itemView.findViewById<View>(R.id.txt_title) as TextView
            var txt_content = itemView.findViewById<View>(R.id.txt_content) as TextView
            var txt_author = itemView.findViewById<View>(R.id.txt_author) as TextView

            txt_title.text = postList[position].emailAddress
            /* itemView.setOnClickListener {
                 itemClickListener.invoke(postList!![adapterPosition] , true)
             }*/
        }
    }

}