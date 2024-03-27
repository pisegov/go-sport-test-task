package com.example.pizza_test_task.ui.menu.categories

import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.ItemCategoryBinding
import com.example.pizza_test_task.util.ViewBindingKotlinModel

data class CategoryEpoxyModel(
    val id: String,
    val model: Category,
) : ViewBindingKotlinModel<ItemCategoryBinding>(R.layout.item_category) {

    init {
        id(id)
    }

    override fun ItemCategoryBinding.bind() {
        button.text = model.text
    }
}