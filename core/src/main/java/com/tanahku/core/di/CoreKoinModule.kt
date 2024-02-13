package com.tanahku.core.di

import com.tanahku.core.data.Repository
import com.tanahku.core.data.local.LocalDataSource
import com.tanahku.core.data.local.room.DeviceDatabase
import com.tanahku.core.data.remote.RemoteDataSource
import com.tanahku.core.domain.repository.RepositoryInterface
import org.koin.dsl.module

val repository = module {
    single { RemoteDataSource() }
    factory { get<DeviceDatabase>().deviceDao() }
    single { DeviceDatabase.getInstance(get()) }
    single { LocalDataSource(get()) }
    factory<RepositoryInterface> { Repository(get(),get()) }
}