package com.tanahku.core.data.remote

import android.util.Log
import com.tanahku.core.data.remote.model.response.ResponseDataItem
import com.tanahku.core.data.remote.model.response.ResponseSensorDataItem
import com.tanahku.core.data.remote.model.response.vo.ApiResponse
import com.tanahku.core.data.remote.network.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource {
    suspend fun getDevice(): Flow<ApiResponse<List<ResponseDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getDevice()
                val listDevice = response.data
                Log.e("hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getWindspeedLimit(deviceId: Int): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getWindspeedLimit(deviceId, 24)
                val listDevice = response.data
                Log.e("Remote hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun getSoilmoistureLimit(deviceId: Int): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getSoilmoistureLimit(deviceId, 24)
                val listDevice = response.data
                Log.e("Remote hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getHumidLimit(deviceId: Int): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getHumidLimit(deviceId, 24)
                val listDevice = response.data
                Log.e("Remote hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAirtempLimit(deviceId: Int): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getAirtempLimit(deviceId, 24)
                val listDevice = response.data
                Log.e("Remote hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getRainfallLimit(deviceId: Int): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getRainfallLimit(deviceId, 24)
                val listDevice = response.data
                Log.e("Remote hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getSoilphLimit(deviceId: Int): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getSoilphLimit(deviceId, 24)
                val listDevice = response.data
                Log.e("Remote hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getSolarradiationLimit(deviceId: Int): Flow<ApiResponse<List<ResponseSensorDataItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getSolarradiationLimit(deviceId, 24)
                val listDevice = response.data
                Log.e("Remote hasil", "getDevice: ${listDevice}")
                emit(ApiResponse.Success(listDevice))
            } catch (e: Exception) {
                Log.e("Remote", "getDevice: ${e.message}")
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}