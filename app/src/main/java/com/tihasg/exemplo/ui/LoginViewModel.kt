package com.tihasg.exemplo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tihasg.exemplo.base.BaseViewModel
import com.tihasg.exemplo.repository.Repository
import java.lang.Exception

class LoginViewModel(
    private val repository: Repository,
) : BaseViewModel() {

    private val _state = MutableLiveData<ScreenState>()
    val state: LiveData<ScreenState>
        get() = _state


    fun searchByFlagAndBranchOne(filial: Int) {
        try {
            coroutineScope {
                val response = repository.searchByFlagAndBranch(
                    bandeira = 1,
                    filial = filial
                )

                if (response.code() == 204) {
                    _state.postValue(ScreenState.OnGetFlagError("FILIAL NÃO ENCONTRADA"))
                }

                if (response.isSuccessful) {
                    response.body()?.let { branchGetResponse ->
                        _state.postValue(
                            ScreenState.OnGetFlagSucess(
                                branchGetResponse.codigo.toString()
                            )
                        )
                    }


                } else {
                    searchByFlagAndBranchTwo(filial = filial)
                }
            }
        }catch (e: Exception){
            print(e.message)
        }

    }

    private fun searchByFlagAndBranchTwo(filial: Int) {
        coroutineScope {
            val response = repository.searchByFlagAndBranch(
                bandeira = 2,
                filial = filial
            )

            if (response.code() == 204) {
                _state.postValue(ScreenState.OnGetFlagError("FILIAL NÃO ENCONTRADA"))
            }

            if (response.isSuccessful) {
                response.body()?.let { branchGetResponse ->
                    _state.postValue(
                        ScreenState.OnGetFlagSucess(
                            branchGetResponse.codigo.toString()
                        )
                    )
                }
            } else {
                val message = response.errorBody().toString()
                _state.postValue(ScreenState.OnGetFlagError(message))
            }
        }
    }

    sealed class ScreenState {

        data class OnGetFlagSucess(val branchCode: String) : ScreenState()
        data class OnGetFlagError(val message: String) : ScreenState()

    }
}