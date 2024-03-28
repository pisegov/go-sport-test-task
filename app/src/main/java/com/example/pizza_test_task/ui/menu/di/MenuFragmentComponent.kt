package com.example.pizza_test_task.ui.menu.di

import androidx.fragment.app.Fragment
import com.example.pizza_test_task.di.ApplicationComponent
import com.example.pizza_test_task.ui.menu.MenuViewModel
import com.example.pizza_test_task.ui.menu.banners.BannersEpoxyController
import com.example.pizza_test_task.ui.menu.categories.CategoriesEpoxyController
import com.example.pizza_test_task.ui.menu.menu_list.MenuEpoxyController
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Scope

@MenuFragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [MenuFragmentModule::class])
interface MenuFragmentComponent {
    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance fragment: Fragment,
            @BindsInstance viewModel: MenuViewModel,
        ): MenuFragmentComponent
    }

    val fragment: Fragment
    val viewModel: MenuViewModel
    val categoriesEpoxyController: CategoriesEpoxyController
    val bannersEpoxyController: BannersEpoxyController
    val menuEpoxyController: MenuEpoxyController
}

@Module
interface MenuFragmentModule

@Scope
annotation class MenuFragmentScope