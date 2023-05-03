package com.example.dailypaper.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dailypaper.model.SurfaceNews
import com.example.dailypaper.repository.Repository

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 19:55
 */
class TheViewModel : ViewModel() {

    val newsList = ArrayList<SurfaceNews.News>()
    val topNewsList = ArrayList<SurfaceNews.TopNews>()
    val todayLiveData = Repository.getNew()
}