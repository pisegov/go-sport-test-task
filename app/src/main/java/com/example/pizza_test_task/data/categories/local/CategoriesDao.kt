package com.example.pizza_test_task.data.categories.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pizza_test_task.di.ApplicationScope
import kotlinx.coroutines.flow.Flow

@ApplicationScope
@Dao
interface CategoriesDao {

    @Query("select * from Category")
    fun observeCategories(): Flow<List<CategoryEntity>>

    @Query("delete from Category")
    fun clearCategories()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNew(items: Iterable<CategoryEntity>)

    @Transaction
    fun insertCategories(items: Iterable<CategoryEntity>) {
        clearCategories()
        insertNew(items)
    }

    @Query("select distinct id from Category where selected == 1")
    fun getSelectedId(): Long

    @Query("update Category set selected = 0")
    fun resetSelected()

    @Query("update Category set selected = 1 where id = :categoryId") // Set provided id to true
    fun setSelected(categoryId: Long)

    @Transaction
    suspend fun updateSelection(categoryId: Long) {
        resetSelected()
        setSelected(categoryId)
    }
}