package com.example.pizza_test_task.data.menu_items.local

import androidx.room.Entity

@Entity(
    tableName = "MenuItem",
    primaryKeys = ["id"],
    // foreignKeys = [
    //     ForeignKey(
    //         entity = CategoryEntity::class,
    //         parentColumns = ["title"],
    //         childColumns = ["categoryTitle"]
    //     )
    // ],
)
data class MenuItemEntity(
    val id: Long,
    val title: String,
    val categoryTitle: String,
    val description: String,
    val image: String,
)