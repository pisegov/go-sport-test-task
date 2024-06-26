package com.example.pizza_test_task.ui.menu.categories

import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.ItemCategoryBinding
import com.example.pizza_test_task.util.ViewBindingKotlinModel
import com.example.pizza_test_task.util.dpToPx

data class CategoryEpoxyModel(
    val id: String,
    val model: CategoryPresentationModel,
    val onClick: (Long) -> Unit,
) : ViewBindingKotlinModel<ItemCategoryBinding>(R.layout.item_category) {

    init {
        id(id)
    }

    override fun ItemCategoryBinding.bind() {
        button.text = model.text
        if (model.selected) {
            button.elevation = 0f
            button.setTextAppearance(R.style.Base_TextAppearance_AppCompat_Widget_Button_Selected)
            button.isClickable = false
        } else {
            button.elevation = 8.dpToPx().toFloat()
            button.setTextAppearance(R.style.Base_TextAppearance_AppCompat_Widget_Button_Normal)
            button.setOnClickListener {
                onClick(model.id)
            }
            button.isClickable = true
        }
        button.isSelected = model.selected
    }
}