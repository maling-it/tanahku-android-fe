package com.tanahku.di

import com.tanahku.beranda.ListDeviceAdapter
import com.tanahku.beranda.LocationMapViewModel
import com.tanahku.core.domain.usecase.DeviceInteractionRepository
import com.tanahku.core.domain.usecase.DeviceUsecase
import com.tanahku.detail.DetailViewModel
import org.koin.dsl.module

val viewModel = module {
    single { LocationMapViewModel(get()) }
    single { DetailViewModel(get()) }
}
val useCaseModule = module {
    factory<DeviceUsecase> { DeviceInteractionRepository(get()) }
}
val adapter = module {
    single { ListDeviceAdapter() }
}

