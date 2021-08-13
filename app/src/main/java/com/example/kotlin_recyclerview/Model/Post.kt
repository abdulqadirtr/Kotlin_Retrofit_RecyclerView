package com.example.kotlin_recyclerview.Model

data class Post(
    var userId : Int,
    var id : Int,
    var title: String?,
    var body: String? = null
)