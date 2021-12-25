package com.arash.altafi.hilt.utils

import android.app.Application
import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

// use Configuration.Provider For Implementation HiltWorkerFactory To WorkManager

// use this annotation for add class App(G) to Hilt
@HiltAndroidApp
class App : Application() , Configuration.Provider {

    @Inject
    lateinit var factory : HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(factory).build()
    }

}