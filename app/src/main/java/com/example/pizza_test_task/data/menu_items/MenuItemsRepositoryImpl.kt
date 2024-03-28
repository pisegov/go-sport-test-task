package com.example.pizza_test_task.data.menu_items

import com.example.pizza_test_task.data.menu_items.local.MenuItemsLocalDataSource
import com.example.pizza_test_task.data.menu_items.remote.MenuItemsNetworkDataSource
import com.example.pizza_test_task.domain.repository.MenuItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuItemsRepositoryImpl @Inject constructor(
    private val networkDataSource: MenuItemsNetworkDataSource,
    private val localDataSource: MenuItemsLocalDataSource,
) : MenuItemsRepository {
    override val menuItems = localDataSource.menuItems

    override suspend fun loadMenu() = withContext(Dispatchers.IO) {
        val network = networkDataSource.getMenuItems()
        localDataSource.insertMenu(network)
    }
}
