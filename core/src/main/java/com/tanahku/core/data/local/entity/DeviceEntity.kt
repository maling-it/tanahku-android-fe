package com.tanahku.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device")
data class DeviceEntity(
    @ColumnInfo(name = "apiKey")
    val apiKey: String? = null,

    @ColumnInfo(name = "latitude")
    val latitude: String? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "location")
    val location: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "longitude")
    val longitude: String? = null
)
