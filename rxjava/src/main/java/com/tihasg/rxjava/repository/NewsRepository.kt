package com.tihasg.rxjava.repository

import com.tihasg.rxjava.network.NewsApi
import rx.Observable

class Repository(private val api: NewsApi) {

    fun getCount(): Observable<Int> {
        return api.getCount()
    }

    fun getInfo(): Observable<InfoResponse> {
        return api.getInfo()
    }
}
