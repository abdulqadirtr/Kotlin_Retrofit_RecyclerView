package com.example.kotlin_recyclerview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Adapter.PostAdapteer
import com.example.kotlin_recyclerview.viewmodel.MainFragmentViewModelFactory
import com.example.kotlin_recyclerview.repository.MainRepository
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.Retrofit.RetrofitService
import com.example.kotlin_recyclerview.databinding.FragmentShowValuesBinding
import com.example.kotlin_recyclerview.viewmodel.MainFragmentViewModel

class ShowValues : Fragment() {

    private val retrofitService = RetrofitService.getInstance()

    private lateinit var binding: FragmentShowValuesBinding

    val postAdapter = PostAdapteer()

    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_show_values,
            container,
            false
        )
        binding.recyclerPosts.apply {
            setHasFixedSize(true)
            adapter = postAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        viewModel = ViewModelProvider(this, MainFragmentViewModelFactory(MainRepository(retrofitService))).get(MainFragmentViewModel::class.java)
        viewModel.getPosts()

        initObserver(viewModel)

        postAdapter?.itemClickListener = { post, status ->
            Toast.makeText(
                    requireContext(),
                    "Clicked Button  " + post?.title + "  " + status,
                    Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }

  private fun initObserver(viewModel: MainFragmentViewModel) {

        with(viewModel) {

            postLiveData.observe(viewLifecycleOwner, Observer { it ->

                postAdapter.setCards(it)

            })

        }
    }

}