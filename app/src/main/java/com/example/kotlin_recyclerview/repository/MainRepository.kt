package com.example.kotlin_recyclerview.repository

import com.example.kotlin_recyclerview.api.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {

    fun getAllPosts() = retrofitService?.getAllPosts()

}