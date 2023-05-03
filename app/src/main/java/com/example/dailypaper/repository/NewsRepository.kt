package com.example.dailypaper.repository

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/4/29 21:11
 */

//在该层请求网络数据，并将得到的数据写入Room数据库。需要注意的是，该类只对ViewModel负责
//它提供了两个方法getUser（）和refresh（）。
//当ViewModel需要数据的时候，他不用关心数据是来自网络还是本地数据库。
//在getUser（）方法中，数据直接来源于Room数据库。
//并在每次调用该方法时，都会调用refresh（）方法更新一次数据
//refresh方法也被下拉刷新组件所调用
//class NewsRepository(private val NewsDao: NewsDao, private val newsService: NewsService?) {
//
//    fun getNews(title: String?): LiveData<News> {
//        refresh(title)
//        return NewsDao.getNewByTitle(title)
//    }
//
//    fun refresh(NewsTitle: String?) {
//        newsService?.getNews(NewsTitle)!!.enqueue(object : Callback<News?> {
//            override fun onResponse(call: Call<News?>, response: Response<News?>) {
//                if (response.body() != null) {
//                    insertNew(response.body())
//                }
//            }
//
//            override fun onFailure(call: Call<News?>, t: Throwable) {}
//        })
//    }
//
//    private fun insertNew(news: News?) {
//        AsyncTask.execute { NewsDao?.insertNew(news) }
//    }
//}