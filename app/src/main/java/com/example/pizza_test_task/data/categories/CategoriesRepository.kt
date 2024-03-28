package com.example.pizza_test_task.data.categories

import com.example.pizza_test_task.domain.categories.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val networkDataSource: CategoriesNetworkDataSource,
)  {
    suspend fun loadCategories(): List<Category> = withContext(Dispatchers.IO) {
        return@withContext networkDataSource.getCategories().map { Category(id = it.id, text = it.title) }
    }
}

