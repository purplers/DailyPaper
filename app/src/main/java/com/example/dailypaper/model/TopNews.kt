package com.example.dailypaper.model

import com.google.gson.annotations.SerializedName

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 13:24
 */
data class TopNews (
    val id:Int,

    val image :String,

    val hint : String,

    val title :String,

    val url: String,

    @SerializedName("image_hue")
    val imageHue : String,
)