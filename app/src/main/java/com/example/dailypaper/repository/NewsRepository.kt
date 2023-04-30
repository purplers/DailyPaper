package com.example.dailypaper.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.dailypaper.api.Api
import com.example.dailypaper.db.NewsDao
import com.example.dailypaper.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
*author：石良昊
*email：904839562@qq.com
date : 2023/4/29 21:11
*/
class NewsRepository(private val NewsDao: NewsDao, private val api: Api?) {
    private val TAG = this.javaClass.name
    fun getNews(title: String?): LiveData<News> {
        refresh(title)
        return NewsDao.getNewByTitle(title)
    }

    fun refresh(NewsTitle: String?) {
        api?.getNews(NewsTitle)!!.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                if (response.body() != null) {
                    insertNew(response.body())
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {}
        })
    }

    private fun insertNew(news: News?) {
        AsyncTask.execute { NewsDao?.insertNew(news) }
    }
}