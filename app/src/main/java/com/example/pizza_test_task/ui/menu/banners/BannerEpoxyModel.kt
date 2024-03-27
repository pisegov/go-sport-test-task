package com.example.pizza_test_task.ui.menu.banners

import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.ItemBannerBinding
import com.example.pizza_test_task.util.ViewBindingKotlinModel

data class BannerEpoxyModel(val id: String) : ViewBindingKotlinModel<ItemBannerBinding>(R.layout.item_banner){
    init {
        id(id)
    }

    override fun ItemBannerBinding.bind() {
    }
}