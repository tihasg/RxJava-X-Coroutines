package com.tihasg.rxjava.network

import com.tihasg.rxjava.repository.InfoResponse
import retrofit2.http.GET
import rx.Observable

interface NewsApi {
    @GET("articles/count")
    fun getCount(): Observable<Int>

    @GET("info")
    fun getInfo(): Observable<InfoResponse>
}