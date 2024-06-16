package com.example.kotlin_recyclerview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import com.example.kotlin_recyclerview.viewmodel.MainFragmentViewModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ShowValues : Fragment() {
    var recyclerView: RecyclerView? = null

    private val retrofitService = RetrofitService.getInstance()

    val adapter = PostAdapteer()

    lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_show_values, container, false)
        recyclerView = view.findViewById(R.id.recycler_posts)
        recyclerView?.setHasFixedSize(true)
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

        return view
    }

  private fun initObserver(viewModel: MainFragmentViewModel) {

        with(viewModel) {

            postLiveData.observe(viewLifecycleOwner, Observer { it ->

                adapter.setCards(it)

            })

        }
    }

}