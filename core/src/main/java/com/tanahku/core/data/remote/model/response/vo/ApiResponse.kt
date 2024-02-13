package com.tanahku.core.data.remote.model.response.vo

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val message: String): ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()

}