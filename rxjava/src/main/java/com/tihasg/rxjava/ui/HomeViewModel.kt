package com.tihasg.rxjava.ui

import androidx.lifecycle.ViewModel
import com.tihasg.rxjava.repository.InfoResponse
import com.tihasg.rxjava.repository.Repository
import rx.Observable

class HomeViewModel(
    private val repository: Repository,
) : ViewModel() {

    fun loadCount(): Observable<Int> {
        return repository
            .getCount()
            .map {
                it
            }
    }

    fun loadInfo(): Observable<InfoResponse> {
        return repository
            .getInfo()
            .map {
                it
            }
    }

}
