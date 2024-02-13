package com.tanahku.core.data

import android.util.Log
import com.tanahku.core.data.remote.model.response.vo.ApiResponse
import com.tanahku.core.utils.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.loading())
        val dbSource = loadFromDb().first()
        if (shouldFetch(dbSource)) {
            emit(Resource.loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    Log.e("Check", ": ${apiResponse.data}" )
                    emitAll(loadFromDb().map {
                        Log.e("itttt", ":$it " )
                        Resource.success(
                            it
                        )

                    })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDb().map {
                        Resource.success(
                            it
                        )
                    })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(
                        Resource.error(
                            apiResponse.message
                        )
                    )
                }
            }
        } else {
            emitAll(loadFromDb().map {
                Resource.success(
                    it
                )
            })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract suspend fun loadFromDb(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result
}