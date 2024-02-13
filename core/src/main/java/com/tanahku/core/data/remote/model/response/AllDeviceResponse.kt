package com.tanahku.core.data.remote.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AllDeviceResponse(

	@field:SerializedName("data")
	val data: List<ResponseDataItem>,

	@field:SerializedName("paging")
	val paging: Paging? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class ResponseDataItem(

	@field:SerializedName("apiKey")
	val apiKey: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
) : Parcelable

@Parcelize
data class Paging(

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("totalItem")
	val totalItem: Int? = null,

	@field:SerializedName("totalPage")
	val totalPage: Int? = null,

	@field:SerializedName("currentPage")
	val currentPage: Int? = null
) : Parcelable
