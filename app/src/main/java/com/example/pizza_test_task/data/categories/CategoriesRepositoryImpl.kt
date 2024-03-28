package com.example.pizza_test_task.data.categories

import com.example.pizza_test_task.data.categories.local.CategoriesLocalDataSource
import com.example.pizza_test_task.data.categories.remote.CategoriesNetworkDataSource
import com.example.pizza_test_task.domain.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val networkDataSource: CategoriesNetworkDataSource,
    private val localDataSource: CategoriesLocalDataSource,
) : CategoriesRepository {
    override val categories = localDataSource.categories
    override suspend fun loadCategories() = withContext(Dispatchers.IO) {
        val network = networkDataSource.getCategories()
        localDataSource.insertCategories(network)
    }

    override suspend fun updateSelection(selectedCategoryId: Long) {
        localDataSource.updateSelection(selectedCategoryId)
    }
}

