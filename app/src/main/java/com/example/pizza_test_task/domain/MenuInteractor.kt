package com.example.pizza_test_task.domain

import com.example.pizza_test_task.data.categories.CategoriesRepository
import com.example.pizza_test_task.domain.categories.Category
import com.example.pizza_test_task.ui.menu.menu_list.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuInteractor @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
) {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val _state = MutableStateFlow(
        emptyMap<Category, List<MenuItem>>()
    )
    val state = _state.asStateFlow()

    fun loadData() {
        scope.launch {
            val categories = categoriesRepository.loadCategories()

            _state.update {
                val map = mutableMapOf<Category, List<MenuItem>>()
                categories.forEach {category ->
                    map[category] = listOf()
                }
                map
            }
        }
    }
}