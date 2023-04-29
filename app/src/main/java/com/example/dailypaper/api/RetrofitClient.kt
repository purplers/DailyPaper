package com.example.dailypaper.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:56
 */
class RetrofitClient {
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
    .build()

    val api: Api
        get() = retrofit.create(Api::class.java)

    companion object {
        private const val BASE_URL = "https://github.com/RQ527/ZHIHUAPI"
        private var retrofitClient: RetrofitClient? = null

        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()
                }
                return retrofitClient
            }
    }
}