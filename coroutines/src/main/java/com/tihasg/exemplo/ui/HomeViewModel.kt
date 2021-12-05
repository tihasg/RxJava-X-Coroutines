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

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _info = MutableLiveData<InfoResponse>()
    val info: LiveData<InfoResponse>
        get() = _info

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    /*Dispatchers.Main: use este agente para executar uma corrotina na linha de execução principal do Android. Ele só deve ser usado para interagir com a IU e realizar um trabalho rápido.
    Exemplos incluem chamar funções suspend, executar operações de framework de IU do Android e atualizar objetos LiveData.*/

    /*Dispatchers.IO: este agente é otimizado para executar E/S de disco ou rede fora da linha de execução principal. Exemplos incluem uso do componente Room,
    leitura ou gravação de arquivos e execução de qualquer operação de rede.*/

    /*Dispatchers.Default: este agente é otimizado para realizar trabalho intensivo da CPU fora da linha de execução principal.
     Exemplos de casos de uso incluem classificação de uma lista e análise de JSON.
    */

    fun getCount() {
        launch {
            val response = repository.getCount()
            if (response.isSuccessful) {
                _count.postValue(response.body())
            } else {
                _error.postValue(response.errorBody().toString())
            }

        }
    }

    fun getInfo() {
        launch {
            val response = repository.getInfo()
            if (response.isSuccessful) {
                _info.postValue(response.body())
            } else {
                _error.postValue(response.errorBody().toString())
            }
        }

    }

}
