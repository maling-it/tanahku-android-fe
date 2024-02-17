package com.tanahku.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tanahku.core.data.local.entity.AirtempSensorEntity
import com.tanahku.core.data.local.entity.DeviceEntity
import com.tanahku.core.data.local.entity.HumidSensorEntity
import com.tanahku.core.data.local.entity.RainfallSensorEntity
import com.tanahku.core.data.local.entity.SoilSensorEntity
import com.tanahku.core.data.local.entity.SoilphSensorEntity
import com.tanahku.core.data.local.entity.SolarradiationSensorEntity
import com.tanahku.core.data.local.entity.WindSensorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(story: List<DeviceEntity>)

    @Query("SELECT * FROM device")
    fun deivceLocation(): Flow<List<DeviceEntity>>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataWindSensor(story: List<WindSensorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataSoilSensor(story: List<SoilSensorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataHumidSensor(story: List<HumidSensorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataAirtempSensor(story: List<AirtempSensorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataRainfallSensor(story: List<RainfallSensorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataSoilphSensor(story: List<SoilphSensorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataSolarradiationSensor(story: List<SolarradiationSensorEntity>)



    @Query("SELECT * FROM wind_table")
    fun getWindSensorDevice(): Flow<List<WindSensorEntity>>

    @Query("SELECT * FROM soil_table")
    fun getSoilSensorDevice(): Flow<List<SoilSensorEntity>>

    @Query("SELECT * FROM humid_table")
    fun getHumidSensorDevice(): Flow<List<HumidSensorEntity>>

    @Query("SELECT * FROM airtemp_table")
    fun getAirtempSensorDevice(): Flow<List<AirtempSensorEntity>>

    @Query("SELECT * FROM rainfall_table")
    fun getRainfallSensorDevice(): Flow<List<RainfallSensorEntity>>

    @Query("SELECT * FROM soilph_table")
    fun getSoilphSensorDevice(): Flow<List<SoilphSensorEntity>>

    @Query("SELECT * FROM solarradiation_table")
    fun getSolarradiationSensorDevice(): Flow<List<SolarradiationSensorEntity>>



    @Query("SELECT * FROM wind_table LIMIT 1")
    suspend fun getFirstWindSensorEntry(): WindSensorEntity?

    @Query("DELETE from wind_table")
    suspend fun deleteAllWind()



    @Query("SELECT * FROM soil_table LIMIT 1")
    suspend fun getFirstSoilSensorEntry(): SoilSensorEntity?

    @Query("DELETE from soil_table")
    suspend fun deleteAllSoil()


    @Query("SELECT * FROM humid_table LIMIT 1")
    suspend fun getFirstHumidSensorEntry(): HumidSensorEntity?

    @Query("DELETE from humid_table")
    suspend fun deleteAllHumid()


    @Query("SELECT * FROM airtemp_table LIMIT 1")
    suspend fun getFirstAirtempSensorEntry(): AirtempSensorEntity?

    @Query("DELETE from airtemp_table")
    suspend fun deleteAllAirtemp()


    @Query("SELECT * FROM rainfall_table LIMIT 1")
    suspend fun getFirstRainfallSensorEntry(): RainfallSensorEntity?

    @Query("DELETE from rainfall_table")
    suspend fun deleteAllRainfall()


    @Query("SELECT * FROM soilph_table LIMIT 1")
    suspend fun getFirstSoilphSensorEntry(): SoilphSensorEntity?

    @Query("DELETE from soilph_table")
    suspend fun deleteAllSoilph()


    @Query("SELECT * FROM solarradiation_table LIMIT 1")
    suspend fun getFirstSolarradiationSensorEntry(): SolarradiationSensorEntity?

    @Query("DELETE from solarradiation_table")
    suspend fun deleteAllSolarradiation()
}