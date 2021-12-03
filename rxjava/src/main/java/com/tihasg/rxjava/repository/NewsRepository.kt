package com.tihasg.rxjava.repository

import androidx.lifecycle.MutableLiveData
import com.tihasg.rxjava.network.NewsApi
import rx.Single

class Repository(private val api: NewsApi) {

    private val _countCache = MutableLiveData<Int>()

    fun getCount(): Single<Int> {
        return api
            .getcount()
            .doOnSuccess {
                _countCache.postValue(it)
            }
    }

    fun getCacheCount(): Int {
        return _countCache.value?:0
    }
}
