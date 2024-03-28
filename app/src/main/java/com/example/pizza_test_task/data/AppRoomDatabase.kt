package com.example.pizza_test_task.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pizza_test_task.data.categories.local.CategoriesDao
import com.example.pizza_test_task.data.categories.local.CategoryEntity
import com.example.pizza_test_task.data.menu_items.local.MenuItemEntity
import com.example.pizza_test_task.data.menu_items.local.MenuItemsDao

@Database(
    entities = [CategoryEntity::class, MenuItemEntity::class], version = 2
)
abstract class AppRoomDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: AppRoomDatabase? = null
        private const val DATABASE_NAME = "Menu.db"

        fun getInstance(context: Context): AppRoomDatabase {
            if (INSTANCE == null) {
                synchronized(AppRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            AppRoomDatabase::class.java,
                            DATABASE_NAME
                        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

    abstract fun getCategoriesDao(): CategoriesDao
    abstract fun getMenuItemsDao(): MenuItemsDao
}