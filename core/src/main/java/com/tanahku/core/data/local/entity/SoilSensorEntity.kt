package com.tanahku.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "soil_table")
data class SoilSensorEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int? = null,

    @ColumnInfo("value")
    val value: Int? = null,

    @ColumnInfo("deviceId")
    val deviceId: Int? = null,

    @ColumnInfo("createdOn")
    val createdOn: String? = null,
)