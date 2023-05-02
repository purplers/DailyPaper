package com.example.dailypaper

import com.example.dailypaper.api.Api

import com.example.dailypaper.db.NewsDatabase

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 17:59
 */

//在Application中实例化，方便我们统一管理和全局调用，且不用担心生命周期问题，通常伴随着整个应用程序的生命周期
class MyApplication {
    companion object {
        val newsDatabase: NewsDatabase? = null
        val api: Api? = null
    }
}