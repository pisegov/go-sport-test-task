package com.example.pizza_test_task.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.pizza_test_task.data.AppRoomDatabase
import com.example.pizza_test_task.data.categories.local.CategoriesDao
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
    }
}

@Scope
annotation class ApplicationScope