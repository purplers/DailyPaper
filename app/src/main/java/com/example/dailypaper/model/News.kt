package com.example.dailypaper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:58
 */
@Entity(tableName = "News")
class News (
        @field:ColumnInfo(
            name = "id",
        )
        @field:PrimaryKey var id: Int,

        @field:ColumnInfo(
            name = "title",
        ) var title: String,

        @field:ColumnInfo(
            name = "hint",)
        var hint: String,

        @field:ColumnInfo(
            name = "images",
        ) var images: String,

        @field:ColumnInfo(
            name = "url",
        ) var url: String,

        @ColumnInfo(
            name = "date",
        ) var date: Int,
    )
