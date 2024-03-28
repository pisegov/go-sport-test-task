package com.example.pizza_test_task.domain

import com.example.pizza_test_task.data.categories.CategoriesRepository
import com.example.pizza_test_task.domain.categories.Category
import com.example.pizza_test_task.ui.menu.menu_list.MenuItem
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MenuInteractor @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
) {
    val state = categoriesRepository.categories.map { list ->
        MenuState(list, listOf())
    }

    suspend fun loadData() {
        categoriesRepository.loadCategories()
    }

    suspend fun updateCategorySelection(selectedId: Long) {
        categoriesRepository.updateSelection(selectedId)
    }
}

data class MenuState(val categories: List<Category>, val filteredMenu: List<MenuItem>)