package com.example.pizza_test_task.data

import com.example.pizza_test_task.ui.menu.banners.Banner
import com.example.pizza_test_task.ui.menu.categories.Category
import com.example.pizza_test_task.ui.menu.menu_list.MenuItem

object SampleDataStore {
    val categories = listOf(
        Category("Пицца", true),
        Category("Комбо", false),
        Category("Десерты", false),
        Category("Напитки", false),
        Category("Что-то ", false),
        Category("Еще что-то", false),
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