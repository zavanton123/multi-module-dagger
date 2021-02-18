package com.zavanton.demodagger.main.di

import com.zavanton.demodagger.main.MainActivity
import com.zavanton.demodagger.main.MainActivityPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Scope

@Scope
@Retention
annotation class MainActivityScope

@Module(
    subcomponents = [
        MainActivitySubcomponent::class
    ]
)
interface MainActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    fun bindsInjector(
        impl: MainActivitySubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@MainActivityScope
@Subcomponent(
    modules = [
        MainActivityPresenterModule::class
    ]
)
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity> {
    }
}

@Module
class MainActivityPresenterModule {

    @MainActivityScope
    @Provides
    fun providesPresenter(): MainActivityPresenter = MainActivityPresenter()
}