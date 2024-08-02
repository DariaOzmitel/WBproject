package com.example.wbproject.app

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.wbproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MeetingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MeetingApp)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }

}