package com.example.kotlin_recyclerview.Retrofit

import com.example.kotlin_recyclerview.Model.Post
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface IMyAPI {
    @GET("posts")
    fun getAllPost() : Response<List<Post?>?>
}