package com.tanahku.core.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tanahku.core.data.local.entity.AirtempSensorEntity
import com.tanahku.core.data.local.entity.DeviceEntity
import com.tanahku.core.data.local.entity.HumidSensorEntity
import com.tanahku.core.data.local.entity.RainfallSensorEntity
import com.tanahku.core.data.local.entity.SoilSensorEntity
import com.tanahku.core.data.local.entity.SoilphSensorEntity
import com.tanahku.core.data.local.entity.SolarradiationSensorEntity
import com.tanahku.core.data.local.entity.WindSensorEntity

@Database(
    entities = [
        DeviceEntity::class,
        WindSensorEntity::class,
        SoilSensorEntity::class,
        HumidSensorEntity::class,
        AirtempSensorEntity::class,
        RainfallSensorEntity::class,
        SoilphSensorEntity::class,
        SolarradiationSensorEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DeviceDatabase : RoomDatabase() {

    abstract fun deviceDao(): DeviceDao

    companion object {
        @Volatile
        private var instance: DeviceDatabase? = null
        fun getInstance(context: Context): DeviceDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    DeviceDatabase::class.java, "story_db"
                ).build()
            }
    }
}