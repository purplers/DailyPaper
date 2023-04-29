package com.example.dailypaper.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dailypaper.model.New

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:57
 */
@Dao
interface Dao {
    @Query("select * from ")
    fun getNewByTitle(title: String?): LiveData<New?>?

    @Delete
    fun deleteNew(new:New)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNew(new: New?)
}