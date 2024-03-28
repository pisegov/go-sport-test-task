package com.example.pizza_test_task.ui.menu.banners

import com.airbnb.epoxy.EpoxyController
import com.example.pizza_test_task.domain.model.Banner
import javax.inject.Inject

class BannersEpoxyController @Inject constructor() : EpoxyController() {

    var items: List<Banner> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        items.forEachIndexed { index, banner ->
            BannerEpoxyModel(id = "banner_$index", model = banner).addTo(this)
        }
    }
}