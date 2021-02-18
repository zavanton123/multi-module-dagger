package com.zavanton.profiles.di

import com.zavanton.profiles.ui.ProfilesActivity
import com.zavanton.profiles.ui.ProfilesActivityPresenter
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class ProfilesActivityScope

@Module
interface ProfilesActivityModule {

    @ProfilesActivityScope
    @ContributesAndroidInjector(
        modules = [
            ProfilesActivityPresenterModule::class
        ]
    )
    fun contributesInjector(): ProfilesActivity
}

@Module
class ProfilesActivityPresenterModule {

    @ProfilesActivityScope
    @Provides
    fun providesPresenter(): ProfilesActivityPresenter = ProfilesActivityPresenter()
}