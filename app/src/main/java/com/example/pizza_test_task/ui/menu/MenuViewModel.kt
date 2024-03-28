package com.example.pizza_test_task.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizza_test_task.domain.MenuInteractor
import com.example.pizza_test_task.ui.menu.categories.CategoryPresentationModel
import com.example.pizza_test_task.ui.menu.menu_list.MenuItem
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val interactor: MenuInteractor,
) : ViewModel() {

    val state = interactor.state.map { domainState ->
        MenuScreenState(
            domainState.categories.map {
                CategoryPresentationModel(
                    it.id,
                    it.text,
                    it.selected
                )
            },
        )
    }

    init {
        viewModelScope.launch {
            interactor.loadData()
        }
    }

    fun onCategoryClicked(id: Long) {
        viewModelScope.launch {
            interactor.updateCategorySelection(id)
        }
    }
}

data class MenuScreenState(
    val categories: List<CategoryPresentationModel>,
    val filteredMenu: List<MenuItem> = listOf(),
)