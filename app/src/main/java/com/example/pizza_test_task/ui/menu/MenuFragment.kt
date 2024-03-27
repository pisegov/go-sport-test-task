package com.example.pizza_test_task.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pizza_test_task.App
import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.FragmentMenuBinding
import com.example.pizza_test_task.ui.menu.banners.Banner
import com.example.pizza_test_task.ui.menu.categories.Category
import com.example.pizza_test_task.ui.menu.di.DaggerMenuFragmentComponent
import com.example.pizza_test_task.ui.menu.di.MenuFragmentComponent
import com.example.pizza_test_task.util.viewBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private val binding by viewBinding(FragmentMenuBinding::bind)

    private val applicationComponent
        get() = App.get(requireContext()).applicationComponent

    private lateinit var component: MenuFragmentComponent

    val viewModel by viewModels<MenuViewModel> { applicationComponent.viewModelFactory }

    val categories = listOf(
        Category("Пицца"),
        Category("Комбо"),
        Category("Десерты"),
        Category("Напитки"),
    )

    val banners = listOf(
        Banner(),
        Banner(),
        Banner(),
        Banner(),
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)

        component = DaggerMenuFragmentComponent.factory().create(applicationComponent, this, viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val categoriesController = component.categoriesEpoxyController.apply {
            items = categories
        }
        binding.categories.setController(categoriesController)

        val bannersController = component.bannersEpoxyController.apply {
            items = banners
        }
        binding.banners.setController(bannersController)
    }
}