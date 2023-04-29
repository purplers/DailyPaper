package com.example.dailypaper.api

import com.example.dailypaper.model.New
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:56
 */
interface Api {
    @GET("new/{newId}")
    fun getNew(
        @Path("newId") newId: String?
    ): Call<New?>?
}