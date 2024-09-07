package com.do55anto5.moviestreaming.core.activity.application

import android.app.Application
import com.do55anto5.moviestreaming.di.appModules
import com.do55anto5.moviestreaming.di.firebaseModule
import com.do55anto5.moviestreaming.di.presenterModule
import com.do55anto5.moviestreaming.di.repositoryModule
import com.do55anto5.moviestreaming.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModules)
        }
    }
}