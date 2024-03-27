package com.example.pizza_test_task.ui.menu.menu_list

import com.airbnb.epoxy.EpoxyController
import javax.inject.Inject

class MenuEpoxyController @Inject constructor(): EpoxyController(){
    var items: List<MenuItem> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        items.forEachIndexed { index, menuItem ->
           MenuItemEpoxyModel(id = "menu_item_${menuItem.title}", model = menuItem).addTo(this)
        }
    }
}