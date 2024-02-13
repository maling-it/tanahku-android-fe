package com.tanahku.beranda

import androidx.lifecycle.asLiveData
import com.tanahku.core.domain.usecase.DeviceUsecase

class LocationMapViewModel(private val usecase: DeviceUsecase) {
    fun getDevice() = usecase.getDeviceLocation().asLiveData()
}