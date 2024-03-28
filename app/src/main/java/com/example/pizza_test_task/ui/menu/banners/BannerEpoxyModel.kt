package com.example.pizza_test_task.ui.menu.banners

import coil.load
import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.ItemBannerBinding
import com.example.pizza_test_task.domain.model.Banner
import com.example.pizza_test_task.util.ViewBindingKotlinModel

data class BannerEpoxyModel(val id: String, val model: Banner) : ViewBindingKotlinModel<ItemBannerBinding>(R.layout.item_banner){
    init {
        id(id)
    }

    override fun ItemBannerBinding.bind() {
       banner.load(model.image) {
           placeholder(R.color.grey)
       }
    }
}