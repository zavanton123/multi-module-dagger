package com.zavanton.demodagger.app.di

import android.content.Context
import com.zavanton.demodagger.app.App
import com.zavanton.demodagger.utils.SoundUtils
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class AppContext

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

    fun inject(app: App)
}

@Module(
    includes = [
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