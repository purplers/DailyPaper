package com.example.dailypaper.net

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 18:41
 */
object NewsNetwork {
    private val newsService = ServiceCreator.create<NewsService>()

    suspend fun getNews() = newsService.getNews().await()
    //声明成挂起函数
    //当外部调用getNews（）函数时，Retrofit就会立即发起网络请求，同时协程也会阻塞住。直到服务器响应我们的请求之后，
    // await（）函数会将解析出来的数据模型对象取出并返回，同时恢复当前协程的运行，getNews（）函数在得到await（）函数的返回值后会将该数据再返回到上一层
    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}