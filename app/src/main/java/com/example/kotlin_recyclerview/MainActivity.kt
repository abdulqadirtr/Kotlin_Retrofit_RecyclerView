package com.example.kotlin_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Adapter.PostAdapteer
import com.example.kotlin_recyclerview.Model.Post
import com.example.kotlin_recyclerview.Retrofit.IMyAPI
import com.example.kotlin_recyclerview.Retrofit.RetrofitClient.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var myAPI: IMyAPI? = null
    var recyler_posts: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      fetchDat()
    }

    private fun fetchDat() {

        //calliing Retrofit Api
        val retrofit = instance
        var mycall= retrofit!!.create(IMyAPI::class.java).posts

        mycall!!.enqueue(object : Callback<List<Post?>?> {
            override fun onFailure(call: Call<List<Post?>?>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Post?>?>, response: Response<List<Post?>?>) {

                displayData(response.body())
            }


        })

    }

    private fun displayData(posts: List<Post?>?) {

        recyler_posts!!.layoutManager = LinearLayoutManager(this)
        val adapter =  PostAdapteer( posts!!)
       recyler_posts!!.adapter = adapter

    }

    override fun onStop() {
        super.onStop()
    }
}