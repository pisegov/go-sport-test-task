package com.example.pizza_test_task.data

import com.example.pizza_test_task.ui.menu.banners.Banner
import com.example.pizza_test_task.ui.menu.menu_list.MenuItem

object SampleDataStore {
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