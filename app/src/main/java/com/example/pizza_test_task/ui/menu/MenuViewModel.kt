package com.example.pizza_test_task.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizza_test_task.domain.MenuInteractor
import com.example.pizza_test_task.ui.menu.categories.CategoryPresentationModel
import com.example.pizza_test_task.ui.menu.menu_list.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    interactor: MenuInteractor,
) : ViewModel() {
    private val _state = MutableStateFlow(
        MenuScreenState(listOf())
    )
    val state: StateFlow<MenuScreenState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            interactor.state.collect { menuState ->
                _state.update { screenState ->
                    with(screenState) {
                        val currentCategory = screenState.categories.find { it.selected }

                        val newCategories = menuState.keys.toList().mapIndexed { index, item ->
                            val selected = if (currentCategory == null) {
                                index == 0
                            }
                            else {
                                currentCategory.text == item.text
                            }

                            CategoryPresentationModel(
                                text = item.text,
                                selected = selected
                            )
                        }
                        if (newCategories.isEmpty()) return@collect

                        copy(categories = newCategories)
                    }
                }
            }
        }
        viewModelScope.launch {
            interactor.loadData()
        }
    }
}

data class MenuScreenState(
    val categories: List<CategoryPresentationModel>,
    val filteredMenu: List<MenuItem> = listOf(),
)