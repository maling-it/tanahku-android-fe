package com.tanahku.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wind_table")
data class WindSensorEntity(
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
