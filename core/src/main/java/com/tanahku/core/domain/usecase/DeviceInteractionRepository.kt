package com.tanahku.core.domain.usecase

import com.tanahku.core.domain.model.DataItem
import com.tanahku.core.domain.repository.RepositoryInterface
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow

class DeviceInteractionRepository(private val repository: RepositoryInterface): DeviceUsecase {
    override fun getDeviceLocation(): Flow<Resource<List<DataItem>>> {
        return repository.getDeviceLocation()
    }

}