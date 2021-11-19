package com.tihasg.rxjava.network

import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {
    @GET("articles/count")
    fun getcount(): Single<Int>
}