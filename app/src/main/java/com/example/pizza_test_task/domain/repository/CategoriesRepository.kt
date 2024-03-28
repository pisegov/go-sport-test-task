package com.example.pizza_test_task.domain.repository

import com.example.pizza_test_task.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    val categories: Flow<List<Category>>

    suspend fun loadCategories()

    suspend fun updateSelection(selectedCategoryId: Long)
}