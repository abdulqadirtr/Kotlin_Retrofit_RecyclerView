package com.example.kotlin_recyclerview.repository

import com.example.kotlin_recyclerview.Retrofit.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {

    fun getAllPosts() = retrofitService?.getAllPosts()

    suspend fun getAllPostsCO() = retrofitService.getAllPostsCO()

}