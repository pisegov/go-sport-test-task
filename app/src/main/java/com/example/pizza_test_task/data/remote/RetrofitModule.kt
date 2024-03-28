package com.example.pizza_test_task.data.remote

import com.example.pizza_test_task.BuildConfig
import com.example.pizza_test_task.data.categories.remote.CategoriesApi
import com.example.pizza_test_task.data.menu_items.remote.MenuItemsApi
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

@ExperimentalSerializationApi
object RetrofitModule {
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    private val httpClient = OkHttpClient().newBuilder()
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
        .build()

    val categoriesApi: CategoriesApi = retrofit.create<CategoriesApi>()
    val menuItemsApi: MenuItemsApi = retrofit.create<MenuItemsApi>()
}
