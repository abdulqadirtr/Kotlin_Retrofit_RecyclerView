package com.example.kotlin_recyclerview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Adapter.PostAdapteer
import com.example.kotlin_recyclerview.Model.Post
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.Retrofit.IMyAPI
import com.example.kotlin_recyclerview.Retrofit.RetrofitClient.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ShowValues : Fragment() {
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_show_values, container, false)
        recyclerView = view.findViewById(R.id.recycler_posts) as RecyclerView
        recyclerView!!.setHasFixedSize(true)


        fetchDat()
        return view
    }

    private fun fetchDat() {
        val retrofit = instance
        var myCall = retrofit!!.create(IMyAPI::class.java)

        myCall.posts.enqueue(object : Callback<List<Post?>?>{
            override fun onFailure(call: Call<List<Post?>?>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post?>?>, response: Response<List<Post?>?>) {
                displayData(response.body())
            }
        })
    }
    private fun displayData(posts: List<Post?>?) {
        val adapter = PostAdapteer(posts)
        recyclerView!!.adapter = adapter
        // Set layout manager to position the items
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.setHasFixedSize(true)

    }

   /* private fun setRecyclerViewScrollListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                if (!imageRequester.isLoadingData && totalItemCount == lastVisibleItemPosition + 1) {
                    requestPhoto()
                }
            }
        })*/
}