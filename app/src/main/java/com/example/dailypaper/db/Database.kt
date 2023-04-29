package com.example.dailypaper.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dailypaper.model.New

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:58
 */
@Database(
    entities = [
        (New::class)
    ], version = 1 , exportSchema = true
)
abstract class Database : RoomDatabase() {
    abstract fun dao():Dao?

    companion object {
        private const val DATABASE_NAME = "new_db"
        private var databaseInstance: Database? = null
        @Synchronized
        fun getInstance(context: Context): Database? {
            if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    DATABASE_NAME
                ).build()
            }
            return databaseInstance
        }
    }

}