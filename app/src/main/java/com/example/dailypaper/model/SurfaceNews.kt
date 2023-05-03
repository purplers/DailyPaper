package com.example.dailypaper.model

import com.google.gson.annotations.SerializedName

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 13:19
 */
data class SurfaceNews(
    @SerializedName("date")
    val date: String,
    @SerializedName("news")
    val news: List<News>,
    @SerializedName("top_news")
    val topNews: List<TopNews>
) {
    data class News (
    @SerializedName("image_hue")
    val imageHue: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("ga_prefix")
    val gaPrefix: String,
    @SerializedName("hint")
    val hint: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("type")
    val type: Int,
    @SerializedName("id")
    val id: Int,
)

    data class TopNews (
        @SerializedName("image_hue")
        val imageHue: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("ga_prefix")
        val gaPrefix: String,
        @SerializedName("hint")
        val hint: String,
        @SerializedName("images")
        val images: List<String>,
        @SerializedName("type")
        val type: Int,
        @SerializedName("id")
        val id: Int,
    )
}