package com.example.dailypaper.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dailypaper.model.News

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:58
 */
@Database(
    entities = [
        (News::class)
    ], version = 1 , exportSchema = true
)
abstract class NewsDatabase : RoomDatabase() {
        abstract fun newsDao(): NewsDao?

        companion object {
            private const val DATABASE_NAME = "user_db"
            private var databaseInstance: NewsDatabase? = null
            @Synchronized
            fun getInstance(context: Context): NewsDatabase? {
                if (databaseInstance == null) {
                    databaseInstance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
                return databaseInstance
            }
        }
    }