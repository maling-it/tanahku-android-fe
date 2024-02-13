package com.tanahku.core.data.local

import android.util.Log
import com.tanahku.core.data.local.entity.DeviceEntity
import com.tanahku.core.data.local.room.DeviceDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class LocalDataSource(private val dao: DeviceDao) {
    suspend fun insertDevice(list: List<DeviceEntity>) = dao.insertData(list)
    suspend fun getDevice(): Flow<List<DeviceEntity>> {
        Log.e("localDataSource", "getDevice: ${dao.deivceLocation().first()}")
        return dao.deivceLocation()
    }

}