package com.example.pizza_test_task.data.menu_items.remote

import com.example.pizza_test_task.data.BaseNetworkDataSource
import com.example.pizza_test_task.data.NetworkResult
import com.example.pizza_test_task.data.remote.RetrofitModule
import com.example.pizza_test_task.di.ApplicationScope
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

@ApplicationScope
class MenuItemsNetworkDataSource @Inject constructor() : BaseNetworkDataSource<List<MenuItemDataModel>>() {
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getMenuItems(): List<MenuItemDataModel> {
        val result = safeApiCall { RetrofitModule.menuItemsApi.getMenuItems().list }
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
