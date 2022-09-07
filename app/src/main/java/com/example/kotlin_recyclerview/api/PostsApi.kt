package com.example.kotlin_recyclerview.api

import com.example.kotlin_recyclerview.Model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface PostsApi {
    @GET("posts")
    fun getAllPost() : Call<List<PostResponse?>?>
}