package com.example.dailypaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.dailypaper.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import com.example.dailypaper.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        newsViewModel.news.observe(this) { news ->
            if (news!= null) {
                activityMainBinding.news = news
            }
        }
        val swipeRefreshLayout: SwipeRefreshLayout = activityMainBinding.swipeRefresh
        swipeRefreshLayout.setOnRefreshListener {
            newsViewModel.refresh()
            swipeRefreshLayout.isRefreshing = false
        }
    }
}