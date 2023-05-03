package com.example.dailypaper.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 18:18
 */
object ServiceCreator {
    private const val BASE_URL = "https://news-at.zhihu.com"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun <T> create(serviceClass: Class<T>):  T = retrofit.create(serviceClass)
    //此时想获取一个AppService接口的动态代理对象可以用
    //val appService = ServiceCreator.create(AppService::class.java)
    //之后可以调用AppService接口中任意方法
    inline fun <reified T> create() : T = create(T::class.java)
    //此时有了新方法
    //val appService = ServiceCreator.create<AppService>()
    //更简洁
}