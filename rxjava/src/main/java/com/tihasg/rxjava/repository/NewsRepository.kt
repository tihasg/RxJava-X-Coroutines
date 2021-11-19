package com.tihasg.rxjava.repository

import com.tihasg.rxjava.network.NewsApi
import com.tihasg.rxjava.network.model.ArticleResponse
import retrofit2.Response

class Repository(private val apiNewsApi: NewsApi) {

    suspend fun getCount(): Response<Int>{
        return apiNewsApi.getcount()
    }

    suspend fun getListNews(): Response<List<ArticleResponse>> {
        return apiNewsApi.listNews()
    }
}