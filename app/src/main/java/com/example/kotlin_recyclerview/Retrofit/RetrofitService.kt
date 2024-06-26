package com.example.kotlin_recyclerview.Retrofit

import com.example.kotlin_recyclerview.Model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("posts")
    fun getAllPosts() : Call<List<Post>>

    @GET("posts")
    suspend fun getAllPostsCO() : Response<List<Post>>


    companion object {

        lateinit var retrofitService: RetrofitService

        fun getInstance() : RetrofitService {

            if (!this::retrofitService.isInitialized) {
                val retrofit = Retrofit.Builder()
                        .baseUrl("https://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService
        }
    }
}