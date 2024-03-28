package com.example.pizza_test_task.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseNetworkDataSource <T : Any> {

    protected suspend fun safeApiCall(
        apiCall: suspend () -> T,
    ): NetworkResult<T> = withContext(Dispatchers.IO) {
        try {
            NetworkResult.Success(apiCall.invoke())
        } catch (error: Throwable) {
            NetworkResult.Error
        }
    }
}