package com.zavanton.offers.di

import com.zavanton.offers.ui.OffersActivity
import com.zavanton.offers.ui.OffersActivityPresenter
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
annotation class OffersActivityScope

@Module(
    subcomponents = [
        OffersActivitySubcomponent::class
    ]
)
interface OffersActivityModule {

    @Binds
    @IntoMap
    @ClassKey(OffersActivity::class)
    fun bindsInjector(
        impl: OffersActivitySubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@OffersActivityScope
@Subcomponent(
    modules = [
        OffersActivityPresenterModule::class
    ]
)
interface OffersActivitySubcomponent : AndroidInjector<OffersActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<OffersActivity> {
    }
}


@Module
class OffersActivityPresenterModule {

    @OffersActivityScope
    @Provides
    fun providesPresenter(): OffersActivityPresenter {
        return OffersActivityPresenter()
    }
}