package com.tihasg.rxjava.network

import retrofit2.http.GET
import rx.Observable

interface NewsApi {
    @GET("articles/count")
    fun getCount(): Observable<Int>
}