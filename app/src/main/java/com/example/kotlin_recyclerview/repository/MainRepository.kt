package com.example.kotlin_recyclerview.repository

import com.example.kotlin_recyclerview.Retrofit.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {

    suspend fun getAllPosts() = retrofitService?.getAllMovies()

}