package com.example.dailypaper.model

import com.google.gson.annotations.SerializedName

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 13:19
 */
data class Surface (
    @SerializedName("NewsList")
    val newsList:List<News>,
    @SerializedName("TopNewsList")
    val topNewsList:List<TopNews>,
)