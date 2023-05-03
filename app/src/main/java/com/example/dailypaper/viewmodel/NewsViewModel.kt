package com.example.dailypaper.viewmodel


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 21:23
 */
//class NewsViewModel(application: Application) : AndroidViewModel(application) {
//    private val news: LiveData<News>
//    private val userRepository: NewsRepository
//    private val userTitle = ""
//
//    init {
//        val database = MyApplication.newsDatabase
//        val newsDao = database?.newsDao()
//        userRepository = newsDao?.let { NewsRepository(it, MyApplication.newsService) }!!
//        news = userRepository.getNews(userTitle)
//    }
//
//    fun refresh() {
//        userRepository.refresh(userTitle)
//    }
//}