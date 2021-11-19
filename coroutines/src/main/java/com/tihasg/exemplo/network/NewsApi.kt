package com.tihasg.exemplo.network

import com.tihasg.exemplo.network.model.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("articles/count")
    suspend fun getcount(): Response<Int>

    @GET("articles")
    suspend fun listNews(): Response<List<ArticleResponse>>
}