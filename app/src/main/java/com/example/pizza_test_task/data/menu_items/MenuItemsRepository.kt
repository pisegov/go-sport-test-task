package com.example.pizza_test_task.data.menu_items

import com.example.pizza_test_task.data.menu_items.local.MenuItemsLocalDataSource
import com.example.pizza_test_task.data.menu_items.remote.MenuItemsNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuItemsRepository @Inject constructor(
    private val networkDataSource: MenuItemsNetworkDataSource,
    private val localDataSource: MenuItemsLocalDataSource,
) {
    val menuItems = localDataSource.menuItems

    suspend fun loadMenu() = withContext(Dispatchers.IO) {
        val network = networkDataSource.getMenuItems()
        localDataSource.insertMenu(network)
    }
}
