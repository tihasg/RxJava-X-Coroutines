package com.tihasg.rxjava.repository

import com.tihasg.rxjava.network.NewsApi

class Repository(private val apiNewsApi: NewsApi) {

    fun getCount() = apiNewsApi.getcount()
}
