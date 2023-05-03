package com.example.dailypaper.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailypaper.R
import com.example.dailypaper.adapter.NewsAdapter
import com.example.dailypaper.databinding.FragmentRvBinding
import com.example.dailypaper.viewmodel.TheViewModel
//
//class RvFragment : Fragment() {
//    val viewModel by lazy { ViewModelProvider(this).get(TheViewModel::class.java) }
//
//    private lateinit var adapter: NewsAdapter
//
//    private lateinit var binding: FragmentRvBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_rv,container,false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        binding = FragmentRvBinding.inflate(layoutInflater)
//        binding.fragmentRv.apply {
//            layoutManager = LinearLayoutManager(context)
//        }
//        viewModel.todayLiveData.observe(viewLifecycleOwner,Observer{result})
//    }
//}