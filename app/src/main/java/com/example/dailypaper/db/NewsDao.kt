package com.example.dailypaper.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dailypaper.model.News

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:57
 */
@Dao
interface NewsDao {
    @Query("SELECT * FROM news WHERE title = :title")
    fun getNewByTitle(title: String?): LiveData<News>

    @Delete
    fun deleteNew(news:News?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNew(news: News?)
}