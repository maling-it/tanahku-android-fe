package com.tanahku.core.domain.usecase

import com.tanahku.core.domain.model.DataItem
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow

interface DeviceUsecase {
    fun getDeviceLocation(): Flow<Resource<List<DataItem>>>
}