package com.tanahku.core.domain.repository

import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.core.domain.model.SensorDataDomain
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    fun getDeviceLocation(): Flow<Resource<List<DataItemDomain>>>
    fun getWindspeedLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getSoilmoistureLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getHumidLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getAirtempLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getRainfallLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getSoilphLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
    fun getSolarradiationLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>>
}