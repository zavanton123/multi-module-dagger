package com.zavanton.demodagger.app

import android.app.Application
import com.zavanton.demodagger.app.di.ApplicationComponent
import com.zavanton.demodagger.app.di.DaggerApplicationComponent

class App : Application() {

    var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .bindsContext(this)
            .build()

        applicationComponent?.inject(this)
    }
}