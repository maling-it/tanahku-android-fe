package com.tanahku.core.data.remote.network

import com.tanahku.core.data.remote.model.response.AllDeviceResponse
import com.tanahku.core.data.remote.model.response.SensorResponseWithLimit
import retrofit2.http.*

interface ApiService {

    @GET("device/all")
    suspend fun getDevice(): AllDeviceResponse

    @GET("windspeed/limitdata")
    suspend fun getWindspeedLimit(
        @Query("deviceId") deviceId: Int? = null,
        @Query("limit") limit: Int? = null,
    ): SensorResponseWithLimit

    @GET("soilmoisture/limitdata")
    suspend fun getSoilmoistureLimit(
        @Query("deviceId") deviceId: Int? = null,
        @Query("limit") limit: Int? = null,
    ): SensorResponseWithLimit

    @GET("humidity/limitdata")
    suspend fun getHumidLimit(
        @Query("deviceId") deviceId: Int? = null,
        @Query("limit") limit: Int? = null,
    ): SensorResponseWithLimit

    @GET("airtemperature/limitdata")
    suspend fun getAirtempLimit(
        @Query("deviceId") deviceId: Int? = null,
        @Query("limit") limit: Int? = null,
    ): SensorResponseWithLimit

    @GET("rainfall/limitdata")
    suspend fun getRainfallLimit(
        @Query("deviceId") deviceId: Int? = null,
        @Query("limit") limit: Int? = null,
    ): SensorResponseWithLimit

    @GET("soilph/limitdata")
    suspend fun getSoilphLimit(
        @Query("deviceId") deviceId: Int? = null,
        @Query("limit") limit: Int? = null,
    ): SensorResponseWithLimit

    @GET("solarradiation/limitdata")
    suspend fun getSolarradiationLimit(
        @Query("deviceId") deviceId: Int? = null,
        @Query("limit") limit: Int? = null,
    ): SensorResponseWithLimit

}