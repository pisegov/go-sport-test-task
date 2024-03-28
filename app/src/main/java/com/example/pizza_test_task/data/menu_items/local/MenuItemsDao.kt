package com.example.pizza_test_task.data.menu_items.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pizza_test_task.di.ApplicationScope
import kotlinx.coroutines.flow.Flow

@ApplicationScope
@Dao
interface MenuItemsDao {
    @Query("select MenuItem.* from MenuItem left join Category on categoryTitle=Category.title where selected == 1")
    fun observeFilteredMenu(): Flow<List<MenuItemEntity>>

    @Query("delete from MenuItem")
    fun clearMenu()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNew(items: Iterable<MenuItemEntity>)

    @Transaction
    fun insertMenuItems(items: Iterable<MenuItemEntity>) {
        clearMenu()
        insertNew(items)
    }
}
