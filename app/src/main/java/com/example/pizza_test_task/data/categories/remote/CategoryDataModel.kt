package com.example.pizza_test_task.data.categories.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryDataModel(
    @SerialName("idCategory") val id: Long,
    @SerialName("strCategory") val title: String,
)