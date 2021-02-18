package com.zavanton.demodagger.main.di

import com.zavanton.demodagger.main.fragment.MainFragment
import com.zavanton.demodagger.main.fragment.MainFragmentPresenter
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
annotation class MainFragmentScope

@Module(
    subcomponents = [
        MainFragmentSubcomponent::class
    ]
)
interface MainFragmentModule {

    @Binds
    @IntoMap
    @ClassKey(MainFragment::class)
    fun bindsInjector(
        impl: MainFragmentSubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@MainFragmentScope
@Subcomponent(
    modules = [
        MainFragmentPresenterModule::class
    ]
)
interface MainFragmentSubcomponent : AndroidInjector<MainFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainFragment> {
    }
}

@Module
class MainFragmentPresenterModule {

    @MainFragmentScope
    @Provides
    fun providesPresenter(): MainFragmentPresenter = MainFragmentPresenter()
}