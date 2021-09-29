package com.tihasg.exemplo.ui

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.tihasg.exemplo.R
import com.tihasg.navigation.NavigationController
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.searchByFlagAndBranchOne(1000)
        bindStates()
    }


    private fun bindStates() {
        viewModel.state.observeForever {
            when (it) {
                is LoginViewModel.ScreenState.OnGetFlagError -> {
                    NavigationController.instance?.showError()
                        ?.goToShowError(
                            this,
                            it.message,
                            Gravity.CENTER
                        )
                }
                is LoginViewModel.ScreenState.OnGetFlagSucess -> {
                    NavigationController.instance?.showError()
                        ?.goToShowError(
                            this,
                            "SUCESSSO",
                            Gravity.CENTER
                        )
                }
                else -> {
                    NavigationController.instance?.showError()
                        ?.goToShowError(
                            this,
                            "INVALIDO",
                            Gravity.CENTER
                        )
                }
            }
        }
    }

}