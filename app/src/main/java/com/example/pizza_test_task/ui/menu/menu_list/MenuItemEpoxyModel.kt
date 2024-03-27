package com.example.pizza_test_task.ui.menu.menu_list

import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.ItemMenuBinding
import com.example.pizza_test_task.util.ViewBindingKotlinModel

data class MenuItemEpoxyModel(val id: String, val model: MenuItem): ViewBindingKotlinModel<ItemMenuBinding>(R.layout.item_menu) {
    init {
        id(id)
    }
    override fun ItemMenuBinding.bind() {
        title.text = model.title
        description.text = model.description
        button.text = model.buttonText
    }
}
