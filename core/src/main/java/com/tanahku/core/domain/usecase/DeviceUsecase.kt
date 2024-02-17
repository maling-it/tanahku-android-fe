package com.tanahku.core.domain.usecase

import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.core.domain.model.SensorDataDomain
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow

interface DeviceUsecase {
    fun getDeviceLocation(): Flow<Resource<List<DataItemDomain>>>
    fun getDataSensorWind(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getSoilDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getHumidDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getAirtempDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getRainfallDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getSoilphDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getSolarradiationDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
}