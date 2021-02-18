package com.zavanton.demodagger.app

import android.app.Application
import com.zavanton.demodagger.app.di.DaggerApplicationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent
            .builder()
            .bindsContext(this)
            .build()
            .inject(this)
    }
}