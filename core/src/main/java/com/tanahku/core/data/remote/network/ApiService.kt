package com.tanahku.core.data.remote.network

import com.tanahku.core.data.remote.model.response.AllDeviceResponse
import retrofit2.http.*

interface ApiService {

    @GET("device/all")
    suspend fun getDevice(): AllDeviceResponse

}