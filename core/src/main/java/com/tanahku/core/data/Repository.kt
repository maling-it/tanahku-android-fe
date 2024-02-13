package com.tanahku.core.data

import android.util.Log
import com.tanahku.core.data.local.LocalDataSource
import com.tanahku.core.data.remote.RemoteDataSource
import com.tanahku.core.data.remote.model.response.ResponseDataItem
import com.tanahku.core.data.remote.model.response.vo.ApiResponse
import com.tanahku.core.domain.model.DataItem
import com.tanahku.core.domain.repository.RepositoryInterface
import com.tanahku.core.utils.DataMapper
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): RepositoryInterface {
    override fun getDeviceLocation(): Flow<Resource<List<DataItem>>> {
        return object : NetworkBoundResource<List<DataItem>, List<ResponseDataItem>>(){
            override suspend fun loadFromDb(): Flow<List<DataItem>> {
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

            override fun shouldFetch(data: List<DataItem>?): Boolean {
                Log.e("fetch", "shouldFetch: ${data}")
                return data == null || data.isEmpty()
            }

        }.asFlow()
    }
}