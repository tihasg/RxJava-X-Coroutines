package com.tihasg.rxjava

import android.app.Application
import com.orhanobut.hawk.Hawk
import com.tihasg.exemplo.di.loginModule
import com.tihasg.navigation.ErrorNavigationController
import com.tihasg.navigation.NavigationController
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        setupHawk()
        setupKoin()
        setupNavigationController()
    }

    class NavigationControllerImpl : NavigationController {
        override fun showError(): ErrorNavigationController {
            return ErrorNavigationControllerImpl()
        }
    }

    private fun setupNavigationController() {
        NavigationController.instance = NavigationControllerImpl()
    }

    private fun setupHawk() = Hawk.init(this).build()

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Application)
            androidFileProperties()
            modules(
                loginModule
            )
        }
    }
}
