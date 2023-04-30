package com.example.dailypaper.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.dailypaper.MyApplication
import com.example.dailypaper.model.News
import com.example.dailypaper.repository.NewsRepository

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 21:23
 */
class NewsViewModel(application: Application) : AndroidViewModel(application) {
    val news: LiveData<News>
    private val userRepository: NewsRepository
    private val userTitle = ""

    init {
        val database = MyApplication.newsDatabase
        val newsDao = database?.newsDao()
        userRepository = newsDao?.let { NewsRepository(it, MyApplication.api) }!!
        news = userRepository.getNews(userTitle)
    }

    fun refresh() {
        userRepository.refresh(userTitle)
    }
}