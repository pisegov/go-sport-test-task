package com.example.pizza_test_task.ui.menu.categories

import com.airbnb.epoxy.EpoxyController
import com.example.pizza_test_task.ui.menu.MenuViewModel
import javax.inject.Inject

class CategoriesEpoxyController @Inject constructor(private val viewModel: MenuViewModel) : EpoxyController() {
    var items: List<CategoryPresentationModel> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        items.forEach { category ->
            CategoryEpoxyModel(
                id = "category_${category.text}",
                model = category,
                viewModel::onCategoryClicked
            ).addTo(this)
        }
    }
}