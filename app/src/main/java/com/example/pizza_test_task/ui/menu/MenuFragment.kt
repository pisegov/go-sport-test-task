package com.example.pizza_test_task.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyItemSpacingDecorator
import com.example.pizza_test_task.App
import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.FragmentMenuBinding
import com.example.pizza_test_task.ui.menu.banners.BannersEpoxyController
import com.example.pizza_test_task.ui.menu.categories.CategoriesEpoxyController
import com.example.pizza_test_task.ui.menu.di.DaggerMenuFragmentComponent
import com.example.pizza_test_task.ui.menu.di.MenuFragmentComponent
import com.example.pizza_test_task.ui.menu.menu_list.MenuEpoxyController
import com.example.pizza_test_task.util.dpToPx
import com.example.pizza_test_task.util.viewBinding
import kotlinx.coroutines.launch

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private val binding by viewBinding(FragmentMenuBinding::bind)

    private val applicationComponent
        get() = App.get(requireContext()).applicationComponent

    private lateinit var component: MenuFragmentComponent

    private lateinit var categoriesController: CategoriesEpoxyController
    private lateinit var bannersController: BannersEpoxyController
    private lateinit var menuController: MenuEpoxyController

    private val viewModel by viewModels<MenuViewModel> { applicationComponent.viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        component = DaggerMenuFragmentComponent.factory().create(applicationComponent, this, viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect {
                categoriesController.items = it.categories
                menuController.items = it.filteredMenu
                bannersController.items = it.banners
            }
        }
    }

    private fun setupViews() {
        categoriesController = component.categoriesEpoxyController
        binding.categories.setController(categoriesController)

        bannersController = component.bannersEpoxyController
        binding.banners.setController(bannersController)
        binding.banners.addItemDecoration(EpoxyItemSpacingDecorator(16.dpToPx()))

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        menuController = component.menuEpoxyController
        binding.menuItems.setController(menuController)
        binding.menuItems.layoutManager = layoutManager
    }
}