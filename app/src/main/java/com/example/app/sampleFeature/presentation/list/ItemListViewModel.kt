package com.example.app.sampleFeature.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.core.domain.onError
import com.example.app.core.presentation.toUiText
import com.example.app.sampleFeature.domain.Item
import com.example.app.sampleFeature.domain.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(ItemListUIState())
    val state = _state.asStateFlow()

    private val _events = Channel<ItemListEvents>()
    val events = _events.receiveAsFlow()

    init {
        viewModelScope.launch {
            fetchItemList()
        }
        viewModelScope.launch {
            itemRepository
                .observeItemList()
                .collect { itemList ->
                    _state.update {
                        it.copy(
                            itemListState = ItemListState.ListLoaded(itemList)
                        )
                    }
                }
        }
    }

    fun onAction(action: ItemListAction) {
        when (action) {
            is ItemListAction.OnToggleFavorite -> {
                toggleFavorite(action.item)
            }

            else -> {}
        }
    }

    private fun fetchItemList() {
        viewModelScope.launch {
            startLoading()
            itemRepository.fetchItemList()
                .onError { error ->
                    _events.send(ItemListEvents.Error(error.toUiText()))
                }
            endLoading()
        }
    }

    private fun toggleFavorite(item: Item) {
        viewModelScope.launch {
            itemRepository.toggleItemFavoriteStatus(item.id)
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
