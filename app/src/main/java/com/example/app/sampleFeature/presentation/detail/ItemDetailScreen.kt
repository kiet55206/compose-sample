package com.example.app.sampleFeature.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app.R
import com.example.app.core.presentation.components.appBar.AppBar
import com.example.app.core.presentation.components.dialog.ErrorAlertDialog
import com.example.app.core.presentation.components.dialog.ErrorAlertDialogModel
import com.example.app.core.presentation.components.loading.LoadingOverlay
import com.example.app.core.presentation.event.ObserveAsEvents
import com.example.app.sampleFeature.presentation.components.FavoriteButton
import com.example.app.sampleFeature.presentation.detail.components.KeyValueItem
import com.example.app.ui.theme.DS
import kotlinx.coroutines.flow.Flow

@Composable
fun ItemDetailScreenRoot(
    onBackClicked: () -> Unit,
    viewModel: ItemDetailViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HandleEvents(viewModel.events)

    ItemDetailScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is ItemDetailAction.OnBackClicked -> {
                    onBackClicked()
                }

                else -> {}
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun ItemDetailScreen(
    state: ItemDetailUIState,
    onAction: (ItemDetailAction) -> Unit,
) {
    LoadingOverlay(
        isLoading = state.isLoading
    ) {
        Scaffold(
            topBar = { AppBar(
                title = stringResource(R.string.detail_screen),
                hasBackButton = true,
                onBackClicked = { onAction(ItemDetailAction.OnBackClicked) }
            ) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DS.colorScheme.background)
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                when (state.itemDetailState) {
                    is ItemDetailState.ItemDetailLoaded -> {
                        KeyValueItem(
                            key = stringResource(R.string.name),
                            value = state.itemDetailState.item.name,
                        )
                        state.itemDetailState.item.height?.let {
                            KeyValueItem(
                                key = stringResource(R.string.height),
                                value = it.toString(),
                            )
                        }
                        state.itemDetailState.item.weight?.let {
                            KeyValueItem(
                                key = stringResource(R.string.weight),
                                value = it.toString(),
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        FavoriteButton(
                            modifier = Modifier.fillMaxWidth(),
                            isFavorite = state.itemDetailState.item.isFavorite,
                            onToggle = {
                                onAction(ItemDetailAction.OnToggleCatch(state.itemDetailState.item))
                            },
                        )
                    }

                    ItemDetailState.ItemDetailEmpty -> {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}

@Composable
private fun HandleEvents(
    events: Flow<ItemDetailEvents>,
) {
    var dialogModel by remember { mutableStateOf<ErrorAlertDialogModel?>(null) }

    ObserveAsEvents(events = events) { event ->
        when (event) {
            is ItemDetailEvents.Error -> {
                dialogModel = ErrorAlertDialogModel(
                    text = event.errorMessage,
                    onPositiveAction = { dialogModel = null },
                    onDismissAction = { dialogModel = null }
                )
            }
        }
    }

    ErrorAlertDialog(dialogModel)
}
