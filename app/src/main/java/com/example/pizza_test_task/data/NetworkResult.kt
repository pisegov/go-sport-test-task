package com.example.pizza_test_task.data

sealed interface NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>
    data object Error: NetworkResult<Nothing>
}


