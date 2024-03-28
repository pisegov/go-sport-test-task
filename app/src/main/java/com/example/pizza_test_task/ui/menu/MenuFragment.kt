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
import com.example.pizza_test_task.data.SampleDataStore
import com.example.pizza_test_task.databinding.FragmentMenuBinding
import com.example.pizza_test_task.ui.menu.banners.BannersEpoxyController
import com.example.pizza_test_task.ui.menu.categories.CategoriesEpoxyController
import com.example.pizza_test_task.ui.menu.categories.CategoryPresentationModel
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
            }
        }
    }

    private fun setupViews() {
        categoriesController = component.categoriesEpoxyController.apply {
            items = SampleDataStore.categories
        }
        binding.categories.setController(categoriesController)
        // binding.categories.addItemDecoration(EpoxyItemSpacingDecorator(8.dpToPx()))

        bannersController = component.bannersEpoxyController.apply {
            items = SampleDataStore.banners
        }
        binding.banners.setController(bannersController)
        binding.banners.addItemDecoration(EpoxyItemSpacingDecorator(16.dpToPx()))

        menuController = component.menuEpoxyController.apply {
            items = SampleDataStore.menuItems
        }
        binding.menuItems.setController(menuController)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.menuItems.layoutManager = layoutManager
    }
}