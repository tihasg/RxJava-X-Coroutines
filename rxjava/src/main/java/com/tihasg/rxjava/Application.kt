package com.tihasg.rxjava

import android.app.Application
import com.tihasg.rxjava.di.loginModule
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.io.IOException
import java.net.SocketException

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()

    }

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
