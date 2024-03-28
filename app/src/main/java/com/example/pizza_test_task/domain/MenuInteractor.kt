package com.example.pizza_test_task.domain

import com.example.pizza_test_task.data.categories.CategoriesRepository
import com.example.pizza_test_task.data.menu_items.MenuItemsRepository
import com.example.pizza_test_task.domain.model.Category
import com.example.pizza_test_task.domain.model.MenuItem
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class MenuInteractor @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val menuItemsRepository: MenuItemsRepository,
) {
    val state = categoriesRepository.categories.combine(menuItemsRepository.menuItems) { categories, menuItems ->
        MenuState(categories, menuItems)
    }
    suspend fun loadData() {
        categoriesRepository.loadCategories()
        menuItemsRepository.loadMenu()
    }

    suspend fun updateCategorySelection(selectedId: Long) {
        categoriesRepository.updateSelection(selectedId)
    }
}

data class MenuState(val categories: List<Category>, val filteredMenu: List<MenuItem>)