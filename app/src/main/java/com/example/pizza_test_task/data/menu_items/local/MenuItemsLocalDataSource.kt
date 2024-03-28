package com.example.pizza_test_task.data.menu_items.local

import com.example.pizza_test_task.data.menu_items.remote.MenuItemDataModel
import com.example.pizza_test_task.domain.model.MenuItem
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MenuItemsLocalDataSource @Inject constructor(private val dao: MenuItemsDao) {
    val menuItems = dao.observeFilteredMenu().map { list ->
        list.map {
            MenuItem(
                id = it.id,
                title = it.title,
                description = it.description,
                image = it.image
            )
        }
    }

    fun insertMenu(menuItems: List<MenuItemDataModel>) {
        if (menuItems.isEmpty()) return

        val list = menuItems.map {
            MenuItemEntity(
                id = it.id,
                title = it.title,
                categoryTitle = it.categoryTitle,
                description = it.description,
                image = it.image
            )
        }
        dao.insertMenuItems(list)
    }
}