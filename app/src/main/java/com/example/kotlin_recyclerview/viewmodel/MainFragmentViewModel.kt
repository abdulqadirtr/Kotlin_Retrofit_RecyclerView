package com.example.kotlin_recyclerview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_recyclerview.repository.MainRepository
import com.example.kotlin_recyclerview.Model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel(private val mainRepository: MainRepository?) : ViewModel() {

    val _postLiveData = MutableLiveData<List<Post>>()

    val postLiveData: LiveData<List<Post>> get() = _postLiveData

    init {
//        getPosts()
        getPostsCo()
    }

    fun getPosts() {
        mainRepository?.getAllPosts()?.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                _postLiveData.postValue(response?.body())
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.stackTrace
            }
        })
    }

    fun getPostsCo() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = mainRepository?.getAllPostsCO()
            if (response?.isSuccessful == true) {
                _postLiveData.postValue(response?.body())
            }
        }
    }

}