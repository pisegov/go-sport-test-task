package com.example.pizza_test_task.data.categories

import com.example.pizza_test_task.data.categories.model.CategoriesResponse
import retrofit2.http.GET

interface CategoriesApi {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}