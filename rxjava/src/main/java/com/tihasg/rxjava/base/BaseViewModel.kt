package com.tihasg.rxjava.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

open class BaseViewModel: ViewModel() {
    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun <T> coroutineScope(action: suspend () -> T) {
        scope.launch {
            try {

            }catch (e: Exception){
                print(e.toString())
            }
        }
    }
}