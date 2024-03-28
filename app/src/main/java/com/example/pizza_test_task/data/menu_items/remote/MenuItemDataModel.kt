package com.example.pizza_test_task.data.menu_items.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItemDataModel (
    @SerialName("idMeal") val id: Long,
    @SerialName("strMeal") val title: String,
    @SerialName("strCategory") val categoryTitle: String,
    @SerialName("strInstructions") val description: String,
    @SerialName("strMealThumb") val image: String,
)

@Serializable
data class MenuItemsResponce (
    @SerialName("meals") val list: List<MenuItemDataModel>
)