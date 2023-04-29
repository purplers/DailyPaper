package com.example.dailypaper.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.dailypaper.api.Api
import com.example.dailypaper.db.Dao
import com.example.dailypaper.model.New
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
*author：石良昊
*email：904839562@qq.com
date : 2023/4/29 21:11
*/
class Repository(private val Dao: Dao, private val api: Api) {
    private val TAG = this.javaClass.name
    fun getNew(title: String?): LiveData<New?>? {
        refresh(title)
        return Dao.getNewByTitle(title)
    }

    fun refresh(NewTitle: String?) {
        api.getNew(NewTitle)!!.enqueue(object : Callback<New?> {
            override fun onResponse(call: Call<New?>, response: Response<New?>) {
                if (response.body() != null) {
                    insertNew(response.body())
                }
            }

            override fun onFailure(call: Call<New?>, t: Throwable) {}
        })
    }

    private fun insertNew(new: New?) {
        AsyncTask.execute { Dao.insertNew(new) }
    }
}