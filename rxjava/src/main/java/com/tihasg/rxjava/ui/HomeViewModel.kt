package com.tihasg.rxjava.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tihasg.rxjava.repository.Repository
import rx.Observable

class HomeViewModel(
    private val repository: Repository,
) : ViewModel() {

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    fun loadCount(): Observable<Int> {
        return repository
            .getCount()
            .toObservable()
            .flatMap {
                _count.postValue(it)
                Observable.just(it)
            }
    }

}
