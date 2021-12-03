package com.tihasg.exemplo.network

import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("articles/count")
    suspend fun getCount(): Response<Int>

    @GET("info")
    suspend fun getInfo(): Response<InfoResponse>
}