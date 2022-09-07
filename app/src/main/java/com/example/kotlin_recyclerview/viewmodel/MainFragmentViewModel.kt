package com.example.kotlin_recyclerview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_recyclerview.repository.MainRepository
import com.example.kotlin_recyclerview.Model.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel(private val mainRepository: MainRepository?) : ViewModel() {

    val _postResponseLiveData = MutableLiveData<List<PostResponse>>()

    val postResponseLiveData: LiveData<List<PostResponse>> get() = _postResponseLiveData

    init {
        getPosts()
    }

    fun getPosts() {
            mainRepository?.getAllPosts()?.enqueue(object : Callback<List<PostResponse>> {
                override fun onResponse(call: Call<List<PostResponse>>?, response: Response<List<PostResponse>>?) {
                    _postResponseLiveData.postValue(response?.body())
                }

                override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                    t.stackTrace
                }
            })
    }

}