package com.martins.milton.middle.earth

import android.app.Application
import com.martins.milton.middle.earth.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}