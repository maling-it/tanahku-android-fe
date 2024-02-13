package com.tanahku.core.domain.repository

import com.tanahku.core.domain.model.DataItem
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    fun getDeviceLocation(): Flow<Resource<List<DataItem>>>
}