package com.example.pizza_test_task.ui.menu.categories

import com.airbnb.epoxy.EpoxyController
import com.example.pizza_test_task.ui.menu.MenuViewModel
import javax.inject.Inject

class CategoriesEpoxyController @Inject constructor(viewModel: MenuViewModel): EpoxyController() {
    var items : List<Category> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        items.forEach { category ->
            CategoryEpoxyModel(id = "category_${category.text}", model = category).addTo(this)
        }
    }
}