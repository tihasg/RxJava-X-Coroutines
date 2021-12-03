package com.tihasg.exemplo.repository

import com.tihasg.exemplo.network.InfoResponse
import com.tihasg.exemplo.network.NewsApi
import retrofit2.Response

class Repository(private val apiNewsApi: NewsApi) {

    suspend fun getCount(): Response<Int> {
        return apiNewsApi.getCount()
    }

    suspend fun getInfo(): Response<InfoResponse> {
        return apiNewsApi.getInfo()
    }
}