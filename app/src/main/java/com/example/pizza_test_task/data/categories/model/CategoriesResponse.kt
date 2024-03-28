package com.example.pizza_test_task.data.categories.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(val categories: List<CategoryDataModel>)
