package com.tihasg.rxjava.network
import retrofit2.http.GET
import rx.Single

interface NewsApi {
    @GET("articles/count")
    fun getcount(): Single<Int>
}