package com.example.pizza_test_task.data.categories.local

import com.example.pizza_test_task.data.categories.remote.CategoryDataModel
import com.example.pizza_test_task.domain.model.Category
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoriesLocalDataSource @Inject constructor(private val dao: CategoriesDao) {
    val categories = dao.observeCategories().map { list ->
        list.map {
            Category(
                id = it.id,
                text = it.title,
                selected = it.selected
            )
        }
    }

    fun insertCategories(categoriesFromNetwork: List<CategoryDataModel>) {
        if (categoriesFromNetwork.isEmpty()) return

        val localSelectedId = dao.getSelectedId()
        val selectedId =
            if (localSelectedId == 0L) {
                categoriesFromNetwork.first().id
            } else {
                localSelectedId
            }
        val categories = categoriesFromNetwork.map {
            CategoryEntity(
                id = it.id,
                title = it.title,
                selected = selectedId == it.id
            )
        }
        dao.insertCategories(categories)
    }

    suspend fun updateSelection(selectedId: Long) {
        dao.updateSelection(selectedId)
    }
}