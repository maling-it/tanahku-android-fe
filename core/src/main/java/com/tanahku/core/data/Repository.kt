package com.tanahku.core.data

import android.util.Log
import com.tanahku.core.data.local.LocalDataSource
import com.tanahku.core.data.remote.RemoteDataSource
import com.tanahku.core.data.remote.model.response.ResponseDataItem
import com.tanahku.core.data.remote.model.response.ResponseSensorDataItem
import com.tanahku.core.data.remote.model.response.vo.ApiResponse
import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.core.domain.model.SensorDataDomain
import com.tanahku.core.domain.repository.RepositoryInterface
import com.tanahku.core.utils.DataMapper
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): RepositoryInterface {
    override fun getDeviceLocation(): Flow<Resource<List<DataItemDomain>>> {
        return object : NetworkBoundResource<List<DataItemDomain>, List<ResponseDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<DataItemDomain>> {
                return localDataSource.getDevice().map { DataMapper.mapEntityToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseDataItem>>> {
                Log.e("call", "createCall: ")
                return remoteDataSource.getDevice()
            }

            override suspend fun saveCallResult(data: List<ResponseDataItem>) {
                val dataMap = DataMapper.mapResponseToEntity(data)
                return localDataSource.insertDevice(dataMap)
            }

            override fun shouldFetch(data: List<DataItemDomain>?): Boolean {
                Log.e("fetch", "shouldFetch: ${data}")
                return true
            }

        }.asFlow()
    }

    override fun getWindspeedLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return object : NetworkBoundResource<List<SensorDataDomain>, List<ResponseSensorDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<SensorDataDomain>> {
                return localDataSource.getWindSensorDevice().map { DataMapper.mapEntityWindSensorToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
                return remoteDataSource.getWindspeedLimit(deviceId)
            }

            override suspend fun saveCallResult(data: List<ResponseSensorDataItem>) {
                val save = DataMapper.mapResponseWindSensorToEntity(data)
                return localDataSource.insertWindDataSensor(save)
            }

            override fun shouldFetch(data: List<SensorDataDomain>?): Boolean {
                return true
            }

        }.asFlow()
    }

    override fun getSoilmoistureLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return object : NetworkBoundResource<List<SensorDataDomain>, List<ResponseSensorDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<SensorDataDomain>> {
                return localDataSource.getSoilSensorDeveice().map { DataMapper.mapEntitySoilSensorToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
               return remoteDataSource.getSoilmoistureLimit(deviceId)
            }

            override suspend fun saveCallResult(data: List<ResponseSensorDataItem>) {
                val save = DataMapper.mapResponseSoilSensorToEntity(data)
                return localDataSource.insertSoilDataSensor(save)
            }

            override fun shouldFetch(data: List<SensorDataDomain>?): Boolean {
                return true
            }

        }.asFlow()
    }

    override fun getHumidLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return object : NetworkBoundResource<List<SensorDataDomain>, List<ResponseSensorDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<SensorDataDomain>> {
                return localDataSource.getHumidSensorDeveice().map { DataMapper.mapEntityHumidSensorToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
                return remoteDataSource.getHumidLimit(deviceId)
            }

            override suspend fun saveCallResult(data: List<ResponseSensorDataItem>) {
                val save = DataMapper.mapResponseHumidSensorToEntity(data)
                return localDataSource.insertHumidDataSensor(save)
            }

            override fun shouldFetch(data: List<SensorDataDomain>?): Boolean {
                return true
            }

        }.asFlow()
    }

    override fun getAirtempLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return object : NetworkBoundResource<List<SensorDataDomain>, List<ResponseSensorDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<SensorDataDomain>> {
                return localDataSource.getAirtempSensorDeveice().map { DataMapper.mapEntityAirtempSensorToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
                return remoteDataSource.getAirtempLimit(deviceId)
            }

            override suspend fun saveCallResult(data: List<ResponseSensorDataItem>) {
                val save = DataMapper.mapResponseAirtempSensorToEntity(data)
                return localDataSource.insertAirtempDataSensor(save)
            }

            override fun shouldFetch(data: List<SensorDataDomain>?): Boolean {
                return true
            }

        }.asFlow()
    }

    override fun getRainfallLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return object : NetworkBoundResource<List<SensorDataDomain>, List<ResponseSensorDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<SensorDataDomain>> {
                return localDataSource.getRainfallSensorDeveice().map { DataMapper.mapEntityRainfallSensorToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
                return remoteDataSource.getRainfallLimit(deviceId)
            }

            override suspend fun saveCallResult(data: List<ResponseSensorDataItem>) {
                val save = DataMapper.mapResponseRainfallSensorToEntity(data)
                return localDataSource.insertRainfallDataSensor(save)
            }

            override fun shouldFetch(data: List<SensorDataDomain>?): Boolean {
                return true
            }

        }.asFlow()
    }

    override fun getSoilphLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return object : NetworkBoundResource<List<SensorDataDomain>, List<ResponseSensorDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<SensorDataDomain>> {
                return localDataSource.getSoilphSensorDeveice().map { DataMapper.mapEntitySoilphSensorToDomain(it) }   }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
                return remoteDataSource.getSoilphLimit(deviceId)     }

            override suspend fun saveCallResult(data: List<ResponseSensorDataItem>) {
                val save = DataMapper.mapResponseSoilphSensorToEntity(data)
                return localDataSource.insertSoilphDataSensor(save)    }

            override fun shouldFetch(data: List<SensorDataDomain>?): Boolean {
                return true
            }

        }.asFlow()
    }

    override fun getSolarradiationLimit(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return object : NetworkBoundResource<List<SensorDataDomain>, List<ResponseSensorDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<SensorDataDomain>> {
                return localDataSource.getSolarradiationSensorDeveice().map { DataMapper.mapEntitySolarradiationSensorToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
                return remoteDataSource.getSolarradiationLimit(deviceId)
            }

            override suspend fun saveCallResult(data: List<ResponseSensorDataItem>) {
                val save = DataMapper.mapResponseSolarradiationSensorToEntity(data)
                return localDataSource.insertSolarradiationDataSensor(save)
            }

            override fun shouldFetch(data: List<SensorDataDomain>?): Boolean {
                return true
            }

        }.asFlow()
    }
}