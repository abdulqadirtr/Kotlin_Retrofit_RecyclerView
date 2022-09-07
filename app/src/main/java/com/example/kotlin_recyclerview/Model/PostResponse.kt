package com.example.kotlin_recyclerview.Model

data class PostResponse(
    var userId : Int,
    var id : Int,
    var title: String?,
    var body: String? = null
)