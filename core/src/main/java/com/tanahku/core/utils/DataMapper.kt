package com.tanahku.core.utils

import com.tanahku.core.data.local.entity.DeviceEntity
import com.tanahku.core.data.remote.model.response.ResponseDataItem
import com.tanahku.core.domain.model.DataItem

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

    fun mapEntityToDomain(list: List<DeviceEntity>): List<DataItem>{
        val mapTo = ArrayList<DataItem>()
        list.map {
            val listTo = DataItem(
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
}