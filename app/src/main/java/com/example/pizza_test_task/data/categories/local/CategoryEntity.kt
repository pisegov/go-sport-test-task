package com.example.pizza_test_task.data.categories.local

import androidx.room.Entity

@Entity(
    tableName = "Category",
    primaryKeys = ["id"]
)
data class CategoryEntity(
    val id: Long,
    val title: String,
    val selected: Boolean,
)