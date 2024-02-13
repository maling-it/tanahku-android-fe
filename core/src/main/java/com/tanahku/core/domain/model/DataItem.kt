package com.tanahku.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataItem(
    val apiKey: String? = null,
    val latitude: String? = null,
    val name: String? = null,
    val location: String? = null,
    val id: Int? = null,
    val longitude: String? = null
) : Parcelable

