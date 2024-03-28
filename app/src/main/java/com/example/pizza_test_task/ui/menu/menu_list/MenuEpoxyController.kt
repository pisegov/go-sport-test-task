package com.example.pizza_test_task.ui.menu.menu_list

import com.airbnb.epoxy.EpoxyController
import javax.inject.Inject

class MenuEpoxyController @Inject constructor() : EpoxyController() {
    var items: List<MenuItemPresentationModel> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        items.forEach {menuItem ->
            MenuItemEpoxyModel(id = "menu_item_${menuItem.id}", model = menuItem).addTo(this)
        }
    }
}