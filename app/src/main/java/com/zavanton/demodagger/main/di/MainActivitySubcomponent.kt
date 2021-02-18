package com.zavanton.demodagger.main.di

import com.zavanton.demodagger.main.MainActivity
import com.zavanton.demodagger.main.MainActivityPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention
annotation class MainActivityScope

@Module(
    subcomponents = [
        MainActivitySubcomponent::class
    ]
)
class MainActivityModule {

}

@MainActivityScope
@Subcomponent(
    modules = [
        MainActivityPresenterModule::class
    ]
)
interface MainActivitySubcomponent {

    @Subcomponent.Factory
    interface Factory {

        fun build(): MainActivitySubcomponent
    }

    fun inject(mainActivity: MainActivity)
}

@Module
class MainActivityPresenterModule {

    @MainActivityScope
    @Provides
    fun providesPresenter(): MainActivityPresenter = MainActivityPresenter()
}