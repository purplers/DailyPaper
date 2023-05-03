package com.example.dailypaper.repository

import androidx.lifecycle.liveData
import com.example.dailypaper.net.NewsNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import kotlin.coroutines.CoroutineContext


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 18:55
 */
object Repository {

    fun getNew() = fire(Dispatchers.IO){
        val surfaceResponse = NewsNetwork.getNews()
        run {
            val surface = surfaceResponse
            Result.success(surface)
        }
    }

    fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}