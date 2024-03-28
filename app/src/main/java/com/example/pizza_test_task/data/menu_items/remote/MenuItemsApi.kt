package com.example.pizza_test_task.data.menu_items.remote

import retrofit2.http.GET

interface MenuItemsApi {
    @GET("search.php?s")
    suspend fun getMenuItems(): MenuItemsResponce
}