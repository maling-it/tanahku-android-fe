package com.tanahku.core.domain.model

import android.os.Parcelable
import com.tanahku.core.data.remote.model.response.Device
import kotlinx.parcelize.Parcelize

@Parcelize
data class SensorDataDomain (
    val id: Int? = null,
    val value: Int? = null,
    val deviceId: Int? = null,
    val createdOn: String? = null,
    val device: Device? = null,
): Parcelable
