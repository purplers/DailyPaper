package com.example.dailypaper.net

import com.example.dailypaper.model.SurfaceNews
import retrofit2.Call
import retrofit2.http.GET

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:56
 */
interface NewsService {
    @GET("api/4/news/latest")
    fun getNews():Call<List<SurfaceNews.News>>
}