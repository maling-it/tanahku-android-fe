package com.tanahku.core.data.local

import android.util.Log
import com.tanahku.core.data.local.entity.AirtempSensorEntity
import com.tanahku.core.data.local.entity.DeviceEntity
import com.tanahku.core.data.local.entity.HumidSensorEntity
import com.tanahku.core.data.local.entity.RainfallSensorEntity
import com.tanahku.core.data.local.entity.SoilSensorEntity
import com.tanahku.core.data.local.entity.SoilphSensorEntity
import com.tanahku.core.data.local.entity.SolarradiationSensorEntity
import com.tanahku.core.data.local.entity.WindSensorEntity
import com.tanahku.core.data.local.room.DeviceDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class LocalDataSource(private val dao: DeviceDao) {
    suspend fun insertDevice(list: List<DeviceEntity>) = dao.insertData(list)
    suspend fun getDevice(): Flow<List<DeviceEntity>> {
        Log.e("localDataSource", "getDevice: ${dao.deivceLocation().first()}")
        return dao.deivceLocation()
    }

    suspend fun insertWindDataSensor(list: List<WindSensorEntity>) {
        val getFirst = dao.getFirstWindSensorEntry()
        if (getFirst != null) {
            dao.deleteAllWind()
        }
        return dao.insertDataWindSensor(list)
    }

    fun getWindSensorDevice(): Flow<List<WindSensorEntity>> {
        Log.e("localDataSource", "getDevice: ${dao.getWindSensorDevice()}")
        return dao.getWindSensorDevice()
    }

    suspend fun insertSoilDataSensor(list: List<SoilSensorEntity>) {
        val getFirst = dao.getFirstSoilSensorEntry()
        if (getFirst != null) {
            dao.deleteAllSoil()
        }
        return dao.insertDataSoilSensor(list)
    }

    fun getSoilSensorDeveice(): Flow<List<SoilSensorEntity>> = dao.getSoilSensorDevice()


    suspend fun insertHumidDataSensor(list: List<HumidSensorEntity>) {
        val getFirst = dao.getFirstHumidSensorEntry()
        if (getFirst != null) {
            dao.deleteAllHumid()
        }
        return dao.insertDataHumidSensor(list)
    }

    fun getHumidSensorDeveice(): Flow<List<HumidSensorEntity>> = dao.getHumidSensorDevice()



    suspend fun insertAirtempDataSensor(list: List<AirtempSensorEntity>) {
        val getFirst = dao.getFirstAirtempSensorEntry()
        if (getFirst != null) {
            dao.deleteAllAirtemp()
        }
        return dao.insertDataAirtempSensor(list)
    }

    fun getAirtempSensorDeveice(): Flow<List<AirtempSensorEntity>> = dao.getAirtempSensorDevice()


    suspend fun insertRainfallDataSensor(list: List<RainfallSensorEntity>) {
        val getFirst = dao.getFirstRainfallSensorEntry()
        if (getFirst != null) {
            dao.deleteAllRainfall()
        }
        return dao.insertDataRainfallSensor(list)
    }

    fun getRainfallSensorDeveice(): Flow<List<RainfallSensorEntity>> = dao.getRainfallSensorDevice()


    suspend fun insertSoilphDataSensor(list: List<SoilphSensorEntity>) {
        val getFirst = dao.getFirstSoilphSensorEntry()
        if (getFirst != null) {
            dao.deleteAllSoilph()
        }
        return dao.insertDataSoilphSensor(list)
    }

    fun getSoilphSensorDeveice(): Flow<List<SoilphSensorEntity>> = dao.getSoilphSensorDevice()


    suspend fun insertSolarradiationDataSensor(list: List<SolarradiationSensorEntity>) {
        val getFirst = dao.getFirstSolarradiationSensorEntry()
        if (getFirst != null) {
            dao.deleteAllSolarradiation()
        }
        return dao.insertDataSolarradiationSensor(list)
    }

    fun getSolarradiationSensorDeveice(): Flow<List<SolarradiationSensorEntity>> = dao.getSolarradiationSensorDevice()
}