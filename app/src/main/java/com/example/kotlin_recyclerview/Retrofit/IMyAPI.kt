package com.example.kotlin_recyclerview.Retrofit

import com.example.kotlin_recyclerview.Model.Post
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface IMyAPI {
    @GET("posts")
    fun getAllPost() : Call<List<Post?>?>
}