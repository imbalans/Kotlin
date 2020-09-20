package com.example.kotlin.ui

import android.app.Application
import com.example.kotlin.data.di.appModule
import com.example.kotlin.data.di.mainModule
import com.example.kotlin.data.di.noteModule
import com.example.kotlin.data.di.splashModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}
