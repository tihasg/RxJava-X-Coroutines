package com.tihasg.exemplo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tihasg.exemplo.base.BaseViewModel
import com.tihasg.exemplo.network.model.ArticleResponse
import com.tihasg.exemplo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val repository: Repository,
) : ViewModel(), CoroutineScope {

    private val _state = MutableLiveData<ScreenState>()
    val state: LiveData<ScreenState>
        get() = _state

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    private val _list = MutableLiveData<List<ArticleResponse>>()
    val list: LiveData<List<ArticleResponse>>
        get() = _list


    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    fun getCount() {
        //aqui onde eu inicio o coroutines
        launch {
            // aqui onde chamo repositorio pra fazer a chamada
            val response = repository.getCount()
            // aqui eu coloco uma verificação para uma verificação se a api deu sucesso
            if (response.isSuccessful) {
                // aqui atualizo meu livedata passando o valor da api
                _count.postValue(response.body())
            }
        }//aqui onde fecho o coroutines
    }

    fun getListNews() {
        //aqui onde eu inicio o coroutines
        launch {
            // aqui onde chamo repositorio pra fazer a chamada
            val response = repository.getListNews()
            // aqui eu coloco uma verificação para uma verificação se a api deu sucesso
            if (response.isSuccessful) {
                // aqui atualizo meu livedata passando o valor da api
                _list.postValue(response.body())
            }
        }//aqui onde fecho o coroutines
    }

    sealed class ScreenState {
        data class OnGetFlagSucess(val branchCode: String) : ScreenState()
        data class OnGetFlagError(val message: String) : ScreenState()
    }
}
