package com.tihasg.exemplo.repository

import com.tihasg.exemplo.network.NewsApi
import com.tihasg.exemplo.network.model.BranchGetResponse
import com.tihasg.exemplo.network.model.CountResponse
import retrofit2.Response

class Repository(private val apiNewsApi: NewsApi) {

    suspend fun getCount(): Response<Int>{
        return apiNewsApi.getcount()
    }
}