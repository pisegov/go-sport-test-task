package com.example.pizza_test_task.domain

import com.example.pizza_test_task.domain.model.Banner
import com.example.pizza_test_task.domain.model.Category
import com.example.pizza_test_task.domain.model.MenuItem
import com.example.pizza_test_task.domain.repository.BannersRepository
import com.example.pizza_test_task.domain.repository.CategoriesRepository
import com.example.pizza_test_task.domain.repository.MenuItemsRepository
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class MenuInteractor @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val menuItemsRepository: MenuItemsRepository,
    private val bannersRepository: BannersRepository,
) {
    val state = categoriesRepository.categories.combine(menuItemsRepository.menuItems) { categories, menuItems ->
        MenuState(categories, menuItems, bannersRepository.getBanners())
    }

    suspend fun loadData() {
        categoriesRepository.loadCategories()
        menuItemsRepository.loadMenu()
    }

    suspend fun updateCategorySelection(selectedId: Long) {
        categoriesRepository.updateSelection(selectedId)
    }
}

data class MenuState(val categories: List<Category>, val filteredMenu: List<MenuItem>, val banners: List<Banner>)