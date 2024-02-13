package com.tanahku

import android.app.Application
import com.tanahku.core.di.repository
import com.tanahku.di.useCaseModule
import com.tanahku.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                listOf(
                    useCaseModule,
                    repository,
                    viewModel
                )
            )
        }
    }
}