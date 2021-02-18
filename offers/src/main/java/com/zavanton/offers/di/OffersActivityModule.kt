package com.zavanton.offers.di

import com.zavanton.offers.ui.OffersActivity
import com.zavanton.offers.ui.OffersActivityPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
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
}

@OffersActivityScope
@Subcomponent(
    modules = [
        OffersActivityPresenterModule::class
    ]
)
interface OffersActivitySubcomponent {

    @Subcomponent.Factory
    interface Factory {

        fun build(): OffersActivitySubcomponent
    }

    fun inject(offersActivity: OffersActivity)
}


@Module
class OffersActivityPresenterModule {

    @OffersActivityScope
    @Provides
    fun providesPresenter(): OffersActivityPresenter {
        return OffersActivityPresenter()
    }
}