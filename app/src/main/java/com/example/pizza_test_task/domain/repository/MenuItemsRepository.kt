package com.example.pizza_test_task.domain.repository

import com.example.pizza_test_task.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

interface MenuItemsRepository {
    val menuItems: Flow<List<MenuItem>>
    suspend fun loadMenu()
}