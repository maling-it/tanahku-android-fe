package com.tanahku.core.domain.usecase

import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.core.domain.model.SensorDataDomain
import com.tanahku.core.domain.repository.RepositoryInterface
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow

class DeviceInteractionRepository(private val repository: RepositoryInterface): DeviceUsecase {
    override fun getDeviceLocation(): Flow<Resource<List<DataItemDomain>>> {
        return repository.getDeviceLocation()
    }

    override fun getDataSensorWind(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return repository.getWindspeedLimit(deviceId)
    }

    override fun getSoilDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return repository.getSoilmoistureLimit(deviceId)
    }

    override fun getHumidDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return repository.getHumidLimit(deviceId)
    }

    override fun getAirtempDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return repository.getAirtempLimit(deviceId)
    }

    override fun getRainfallDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return repository.getRainfallLimit(deviceId)
    }

    override fun getSoilphDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return repository.getSoilphLimit(deviceId)
    }

    override fun getSolarradiationDataSensor(deviceId: Int): Flow<Resource<List<SensorDataDomain>>> {
        return repository.getSolarradiationLimit(deviceId)
    }

}