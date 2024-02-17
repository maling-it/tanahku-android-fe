package com.tanahku.core.utils

import com.tanahku.core.data.local.entity.AirtempSensorEntity
import com.tanahku.core.data.local.entity.DeviceEntity
import com.tanahku.core.data.local.entity.HumidSensorEntity
import com.tanahku.core.data.local.entity.RainfallSensorEntity
import com.tanahku.core.data.local.entity.SoilSensorEntity
import com.tanahku.core.data.local.entity.SoilphSensorEntity
import com.tanahku.core.data.local.entity.SolarradiationSensorEntity
import com.tanahku.core.data.local.entity.WindSensorEntity
import com.tanahku.core.data.remote.model.response.ResponseDataItem
import com.tanahku.core.data.remote.model.response.ResponseSensorDataItem
import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.core.domain.model.SensorDataDomain

object DataMapper {
    fun mapResponseToEntity(list: List<ResponseDataItem>): List<DeviceEntity>{
        val mapTo = ArrayList<DeviceEntity>()
        list.map {
            val listTo = DeviceEntity(
                apiKey = it.apiKey,
                name = it.name,
                id = it.id,
                latitude = it.latitude,
                location = it.location,
                longitude = it.longitude,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntityToDomain(list: List<DeviceEntity>): List<DataItemDomain>{
        val mapTo = ArrayList<DataItemDomain>()
        list.map {
            val listTo = DataItemDomain(
                apiKey = it.apiKey,
                name = it.name,
                id = it.id,
                latitude = it.latitude,
                location = it.location,
                longitude = it.longitude,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapResponseWindSensorToEntity(list: List<ResponseSensorDataItem>): List<WindSensorEntity> {
        val mapTo = ArrayList<WindSensorEntity>()
        list.map {
            val listTo = WindSensorEntity(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntityWindSensorToDomain(list: List<WindSensorEntity>): List<SensorDataDomain>{
        val mapTo = ArrayList<SensorDataDomain>()
        list.map {
            val listTo = SensorDataDomain(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }


    fun mapResponseSoilSensorToEntity(list: List<ResponseSensorDataItem>): List<SoilSensorEntity> {
        val mapTo = ArrayList<SoilSensorEntity>()
        list.map {
            val listTo = SoilSensorEntity(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntitySoilSensorToDomain(list: List<SoilSensorEntity>): List<SensorDataDomain>{
        val mapTo = ArrayList<SensorDataDomain>()
        list.map {
            val listTo = SensorDataDomain(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value
            )
            mapTo.add(listTo)
        }
        return mapTo
    }


    fun mapResponseHumidSensorToEntity(list: List<ResponseSensorDataItem>): List<HumidSensorEntity> {
        val mapTo = ArrayList<HumidSensorEntity>()
        list.map {
            val listTo = HumidSensorEntity(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntityHumidSensorToDomain(list: List<HumidSensorEntity>): List<SensorDataDomain>{
        val mapTo = ArrayList<SensorDataDomain>()
        list.map {
            val listTo = SensorDataDomain(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value
            )
            mapTo.add(listTo)
        }
        return mapTo
    }


    fun mapResponseAirtempSensorToEntity(list: List<ResponseSensorDataItem>): List<AirtempSensorEntity> {
        val mapTo = ArrayList<AirtempSensorEntity>()
        list.map {
            val listTo = AirtempSensorEntity(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntityAirtempSensorToDomain(list: List<AirtempSensorEntity>): List<SensorDataDomain>{
        val mapTo = ArrayList<SensorDataDomain>()
        list.map {
            val listTo = SensorDataDomain(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value
            )
            mapTo.add(listTo)
        }
        return mapTo
    }


    fun mapResponseRainfallSensorToEntity(list: List<ResponseSensorDataItem>): List<RainfallSensorEntity> {
        val mapTo = ArrayList<RainfallSensorEntity>()
        list.map {
            val listTo = RainfallSensorEntity(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntityRainfallSensorToDomain(list: List<RainfallSensorEntity>): List<SensorDataDomain>{
        val mapTo = ArrayList<SensorDataDomain>()
        list.map {
            val listTo = SensorDataDomain(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value
            )
            mapTo.add(listTo)
        }
        return mapTo
    }


    fun mapResponseSoilphSensorToEntity(list: List<ResponseSensorDataItem>): List<SoilphSensorEntity> {
        val mapTo = ArrayList<SoilphSensorEntity>()
        list.map {
            val listTo = SoilphSensorEntity(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntitySoilphSensorToDomain(list: List<SoilphSensorEntity>): List<SensorDataDomain>{
        val mapTo = ArrayList<SensorDataDomain>()
        list.map {
            val listTo = SensorDataDomain(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value
            )
            mapTo.add(listTo)
        }
        return mapTo
    }


    fun mapResponseSolarradiationSensorToEntity(list: List<ResponseSensorDataItem>): List<SolarradiationSensorEntity> {
        val mapTo = ArrayList<SolarradiationSensorEntity>()
        list.map {
            val listTo = SolarradiationSensorEntity(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value,
            )
            mapTo.add(listTo)
        }
        return mapTo
    }

    fun mapEntitySolarradiationSensorToDomain(list: List<SolarradiationSensorEntity>): List<SensorDataDomain>{
        val mapTo = ArrayList<SensorDataDomain>()
        list.map {
            val listTo = SensorDataDomain(
                id = it.id,
                createdOn = it.createdOn,
                deviceId = it.deviceId,
                value = it.value
            )
            mapTo.add(listTo)
        }
        return mapTo
    }
}