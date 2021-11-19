package com.tihasg.rxjava.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tihasg.rxjava.repository.Repository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val repository: Repository,
) : ViewModel() {

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    fun getCount(): Single<Int> {
        return repository
            .getCount()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {  }
            .doFinally {  }
            .map { response ->
                _count.postValue(response)
                response
            }
    }
}
