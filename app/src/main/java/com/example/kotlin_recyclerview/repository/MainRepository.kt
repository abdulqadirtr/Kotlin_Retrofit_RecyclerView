package com.example.kotlin_recyclerview.repository

import com.example.kotlin_recyclerview.Retrofit.IMyAPI
import com.example.kotlin_recyclerview.Retrofit.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {

    fun getAllPosts() = retrofitService?.getAllMovies()

}