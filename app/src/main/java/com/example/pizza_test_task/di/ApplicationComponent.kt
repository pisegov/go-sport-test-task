package com.example.pizza_test_task.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@ApplicationScope
@Component(modules = [ViewModelModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance applicationContext: Context
        ): ApplicationComponent
    }

    val viewModelFactory: ViewModelProvider.Factory
}


@Scope
annotation class ApplicationScope