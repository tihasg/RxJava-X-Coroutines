package com.tihasg.exemplo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tihasg.exemplo.network.InfoResponse
import com.tihasg.exemplo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val repository: Repository,
) : ViewModel(), CoroutineScope {

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    private val _info = MutableLiveData<InfoResponse>()
    val info: LiveData<InfoResponse>
        get() = _info

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    fun getCount() {
        launch {
            val response = repository.getCount()
            if (response.isSuccessful) {
                _count.postValue(response.body())
            }
        }
    }

    fun getInfo(){
        launch {
            val response = repository.getInfo()
            if (response.isSuccessful) {
                _info.postValue(response.body())
            }
        }

    }

}
