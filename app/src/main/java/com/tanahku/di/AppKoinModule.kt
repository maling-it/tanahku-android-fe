package com.tanahku.di

import com.tanahku.beranda.LocationMapViewModel
import com.tanahku.core.domain.usecase.DeviceInteractionRepository
import com.tanahku.core.domain.usecase.DeviceUsecase
import org.koin.dsl.module

val viewModel = module {
    single { LocationMapViewModel(get()) }
}
val useCaseModule = module {
    factory<DeviceUsecase> { DeviceInteractionRepository(get()) }
}

