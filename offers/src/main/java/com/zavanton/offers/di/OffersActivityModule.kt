package com.zavanton.offers.di

import com.zavanton.offers.OffersActivity
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention
annotation class OffersActivityScope

@Module
interface OffersActivityModule {
}

@OffersActivityScope
@Subcomponent
interface OffersActivitySubcomponent {

    fun inject(offersActivity: OffersActivity)
}