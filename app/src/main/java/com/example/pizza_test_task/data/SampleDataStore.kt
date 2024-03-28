package com.example.pizza_test_task.data

import com.example.pizza_test_task.ui.menu.banners.Banner
import com.example.pizza_test_task.ui.menu.categories.CategoryPresentationModel
import com.example.pizza_test_task.ui.menu.menu_list.MenuItem

object SampleDataStore {
    val categories = listOf(
        CategoryPresentationModel("Пицца", true),
        CategoryPresentationModel("Комбо", false),
        CategoryPresentationModel("Десерты", false),
        CategoryPresentationModel("Напитки", false),
        CategoryPresentationModel("Что-то ", false),
        CategoryPresentationModel("Еще что-то", false),
    )

    val banners = listOf(
        Banner(),
        Banner(),
        Banner(),
        Banner(),
    )

    val menuItems = listOf(
        MenuItem(title = "Ветчина и грибы", description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус", buttonText = "от 345 р"),
        MenuItem(title = "Ветчина и грибы", description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус", buttonText = "от 345 р"),
        MenuItem(title = "Ветчина и грибы", description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус", buttonText = "от 345 р"),
        MenuItem(title = "Ветчина и грибы", description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус", buttonText = "от 345 р"),
    )
}