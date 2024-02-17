package com.tanahku.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tanahku.core.domain.usecase.DeviceUsecase

class DetailViewModel(private val usecase: DeviceUsecase): ViewModel() {
    fun getWindData(deviceId: Int) = usecase.getDataSensorWind(deviceId).asLiveData()
    fun getSoilData(deviceId: Int) = usecase.getSoilDataSensor(deviceId).asLiveData()
    fun getHumidData(deviceId: Int) = usecase.getHumidDataSensor(deviceId).asLiveData()
    fun getAirtempData(deviceId: Int) = usecase.getAirtempDataSensor(deviceId).asLiveData()
    fun getRainfallData(deviceId: Int) = usecase.getRainfallDataSensor(deviceId).asLiveData()
    fun getSoilphData(deviceId: Int) = usecase.getSoilphDataSensor(deviceId).asLiveData()
    fun getSolarradiationData(deviceId: Int) = usecase.getSolarradiationDataSensor(deviceId).asLiveData()
}