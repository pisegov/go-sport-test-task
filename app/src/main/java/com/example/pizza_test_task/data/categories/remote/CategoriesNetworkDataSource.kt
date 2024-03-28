package com.example.pizza_test_task.data.categories.remote

import com.example.pizza_test_task.data.BaseNetworkDataSource
import com.example.pizza_test_task.data.NetworkResult
import com.example.pizza_test_task.data.remote.RetrofitModule
import com.example.pizza_test_task.di.ApplicationScope
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

@ApplicationScope
class CategoriesNetworkDataSource @Inject constructor() : BaseNetworkDataSource<List<CategoryDataModel>>() {
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getCategories(): List<CategoryDataModel> {
        val result = safeApiCall { RetrofitModule.categoriesApi.getCategories().categories }
        val newData = when (result) {
            is NetworkResult.Success -> {
                result.data
            }

            is NetworkResult.Error -> {
                emptyList()
            }
        }
        return newData
    }
}
