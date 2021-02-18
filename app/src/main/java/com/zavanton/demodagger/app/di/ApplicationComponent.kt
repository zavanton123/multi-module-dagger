package com.zavanton.demodagger.app.di

import android.content.Context
import com.zavanton.core.AppContext
import com.zavanton.demodagger.app.App
import com.zavanton.demodagger.main.di.MainActivityModule
import com.zavanton.demodagger.main.di.MainActivitySubcomponent
import com.zavanton.demodagger.utils.SoundUtils
import com.zavanton.offers.di.OffersActivityModule
import com.zavanton.profiles.di.ProfilesActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        Modules::class,
        UtilsModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindsContext(@AppContext context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun mainActivitySubcomponentFactory(): MainActivitySubcomponent.Factory

    fun inject(app: App)
}

@Module(
    includes = [
        MainActivityModule::class,
        OffersActivityModule::class,
        ProfilesActivityModule::class
    ]
)
interface Modules


@Module
class UtilsModule {

    @Singleton
    @Provides
    fun providesSoundUtils(context: Context): SoundUtils {
        return SoundUtils(context)
    }
}