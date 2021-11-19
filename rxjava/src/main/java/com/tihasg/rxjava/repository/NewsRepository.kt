package com.tihasg.rxjava.repository

import com.tihasg.rxjava.network.NewsApi
import retrofit2.Response

class Repository(private val apiNewsApi: NewsApi) {

    suspend fun getCount(): Response<Int> {
        return apiNewsApi.getcount()
    }
}