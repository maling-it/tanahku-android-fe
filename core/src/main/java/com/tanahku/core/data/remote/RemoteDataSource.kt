package com.tanahku.core.data.remote

import android.util.Log
import com.tanahku.core.data.remote.model.response.ResponseDataItem
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
}