package com.example.app.sampleFeature.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.app.core.domain.onError
import com.example.app.core.domain.onSuccess
import com.example.app.core.presentation.toUiText
import com.example.app.navigation.NavigationRoute
import com.example.app.sampleFeature.domain.Item
import com.example.app.sampleFeature.domain.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val route = savedStateHandle.toRoute<NavigationRoute.ItemDetail>()

    private val _state = MutableStateFlow(ItemDetailUIState())
    val state = _state

    private val _events = Channel<ItemDetailEvents>()
    val events = _events.receiveAsFlow()

    init {
        fetchItemDetail()
    }

    fun onAction(action: ItemDetailAction) {
        when (action) {
            is ItemDetailAction.OnToggleCatch -> {
                toggleFavorite(action.item)
            }

            else -> {}
        }
    }

    private fun fetchItemDetail() {
        viewModelScope.launch {
            val item = itemRepository.getItemById(route.id)
            if (item != null && item.weight != null && item.height != null) {
                _state.update {
                    it.copy(itemDetailState = ItemDetailState.ItemDetailLoaded(item))
                }
            } else {
                startLoading()
                itemRepository
                    .fetchItemDetail(route.id)
                    .onSuccess { item ->
                        _state.update {
                            it.copy(itemDetailState = ItemDetailState.ItemDetailLoaded(item))
                        }
                    }
                    .onError { error ->
                        _events.send(ItemDetailEvents.Error(error.toUiText()))
                    }
                endLoading()
            }
        }
    }

    private fun toggleFavorite(item: Item) {
        viewModelScope.launch {
            itemRepository.toggleItemFavoriteStatus(item.id)?.let { item ->
                _state.update {
                    it.copy(itemDetailState = ItemDetailState.ItemDetailLoaded(item))
                }
            }
        }
    }

    private fun startLoading() {
        _state.update {
            it.copy(isLoading = true)
        }
    }

    private fun endLoading() {
        _state.update {
            it.copy(isLoading = false)
        }
    }

}
