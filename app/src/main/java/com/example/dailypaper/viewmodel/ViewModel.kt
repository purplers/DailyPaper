package com.example.dailypaper.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.dailypaper.MyApplication.Companion.api
import com.example.dailypaper.MyApplication.Companion.database
import com.example.dailypaper.db.Database
import com.example.dailypaper.model.New
import com.example.dailypaper.repository.Repository

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 21:23
 */
class ViewModel(application: Application) : AndroidViewModel(application) {
    val new: LiveData<New?>?
    private val repository: Repository
    private val title = ""

    init {
        val database = database
        val dao = database!!.dao()
        repository = Repository(dao!!, api!!)
        new = repository.getNew(title)
    }

    fun refresh() {
        repository.refresh(title)
    }
}