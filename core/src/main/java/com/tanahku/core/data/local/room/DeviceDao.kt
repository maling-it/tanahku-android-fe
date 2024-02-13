package com.tanahku.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tanahku.core.data.local.entity.DeviceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(story: List<DeviceEntity>)

    @Query("SELECT * FROM device")
    fun deivceLocation(): Flow<List<DeviceEntity>>
}