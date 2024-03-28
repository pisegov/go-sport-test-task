package com.example.pizza_test_task.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.pizza_test_task.data.AppRoomDatabase
import com.example.pizza_test_task.data.banners.BannersRepositoryImpl
import com.example.pizza_test_task.data.categories.CategoriesRepositoryImpl
import com.example.pizza_test_task.data.categories.local.CategoriesDao
import com.example.pizza_test_task.data.menu_items.MenuItemsRepositoryImpl
import com.example.pizza_test_task.data.menu_items.local.MenuItemsDao
import com.example.pizza_test_task.domain.repository.BannersRepository
import com.example.pizza_test_task.domain.repository.CategoriesRepository
import com.example.pizza_test_task.domain.repository.MenuItemsRepository
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@ApplicationScope
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context,
        ): ApplicationComponent
    }

    val viewModelFactory: ViewModelProvider.Factory
}

@Module
interface ApplicationModule {
    companion object {
        @Provides
        fun provideAppDb(applicationContext: Context): AppRoomDatabase {
            return AppRoomDatabase.getInstance(applicationContext)
        }

        @Provides
        fun provideCategoriesDao(db: AppRoomDatabase): CategoriesDao {
            return db.getCategoriesDao()
        }

        @Provides
        fun provideMenuItemsDao(db: AppRoomDatabase): MenuItemsDao {
            return db.getMenuItemsDao()
        }
    }

    @Binds
    fun bindCategoriesRepository(impl: CategoriesRepositoryImpl): CategoriesRepository

    @Binds
    fun bindMenuRepository(impl: MenuItemsRepositoryImpl): MenuItemsRepository

    @Binds
    fun bindBannersRepository(impl: BannersRepositoryImpl): BannersRepository
}

@Scope
annotation class ApplicationScope