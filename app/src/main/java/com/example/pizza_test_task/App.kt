package com.example.pizza_test_task

import android.app.Application
import android.content.Context
import com.example.pizza_test_task.di.ApplicationScope
import com.example.pizza_test_task.di.DaggerApplicationComponent

@ApplicationScope
class App : Application() {
    val applicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    companion object {
        fun get(context: Context): App = context.applicationContext as App
    }
}
