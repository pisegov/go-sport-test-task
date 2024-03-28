package com.example.pizza_test_task.data.categories

import com.example.pizza_test_task.data.categories.local.CategoriesLocalDataSource
import com.example.pizza_test_task.data.categories.remote.CategoriesNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val networkDataSource: CategoriesNetworkDataSource,
    private val localDataSource: CategoriesLocalDataSource,
) {
    val categories = localDataSource.categories
    suspend fun loadCategories() = withContext(Dispatchers.IO) {
        val network = networkDataSource.getCategories()
        localDataSource.insertCategories(network)
    }

    suspend fun updateSelection(selectedCategoryId: Long) {
        localDataSource.updateSelection(selectedCategoryId)
    }
}

