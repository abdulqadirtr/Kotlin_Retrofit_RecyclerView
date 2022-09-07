package com.example.kotlin_recyclerview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.Adapter.PostAdapter
import com.example.kotlin_recyclerview.viewmodel.MainFragmentViewModelFactory
import com.example.kotlin_recyclerview.repository.MainRepository
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.api.RetrofitService
import com.example.kotlin_recyclerview.viewmodel.MainFragmentViewModel

class PostsFragment : Fragment() {
    var recyclerView: RecyclerView? = null

    private val retrofitService = RetrofitService.getInstance()

    val adapter = PostAdapter()
        lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_show_values, container, false)
        recyclerView = view.findViewById(R.id.recycler_posts) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)

        viewModel = ViewModelProvider(this, MainFragmentViewModelFactory(MainRepository(retrofitService))).get(MainFragmentViewModel::class.java)
        viewModel.getPosts()
        initObserver(viewModel)

        adapter?.itemClickListener = { post, status ->
            Toast.makeText(
                    requireContext(),
                    "Clicked Button  " + post?.title + "  " + status,
                    Toast.LENGTH_SHORT
            ).show()
        }

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        })

        return view
    }

  private fun initObserver(viewModel: MainFragmentViewModel) {

        with(viewModel) {

            postResponseLiveData.observe(viewLifecycleOwner, Observer { posts ->

              adapter.submitList(posts)

            })

        }
    }

}