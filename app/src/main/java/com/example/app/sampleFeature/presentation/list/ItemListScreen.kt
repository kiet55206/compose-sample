package com.example.app.sampleFeature.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app.R
import com.example.app.core.presentation.components.appBar.AppBar
import com.example.app.core.presentation.components.dialog.ErrorAlertDialog
import com.example.app.core.presentation.components.dialog.ErrorAlertDialogModel
import com.example.app.core.presentation.components.loading.LoadingOverlay
import com.example.app.core.presentation.event.ObserveAsEvents
import com.example.app.sampleFeature.domain.Item
import com.example.app.sampleFeature.presentation.list.components.ItemList
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS
import kotlinx.coroutines.flow.Flow

@Composable
fun ItemListScreenRoot(
    onBackClicked: () -> Unit,
    onNavigateToDetailsClicked: (Item) -> Unit,
    viewModel: ItemListViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HandleEvents(events = viewModel.events)

    ItemListScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is ItemListAction.OnBackClicked -> {
                    onBackClicked()
                }

                is ItemListAction.OnItemSelected -> {
                    onNavigateToDetailsClicked(action.item)
                }

                else -> {}
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun ItemListScreen(
    state: ItemListUIState,
    onAction: (ItemListAction) -> Unit,
) {
    LoadingOverlay(
        isLoading = state.isLoading
    ) {
        Scaffold(
            topBar = { AppBar(title = stringResource(R.string.list_screen)) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DS.colorScheme.background)
                    .padding(padding),
            ) {
                when (state.itemListState) {
                    is ItemListState.ListLoaded -> {
                        ItemList(
                            itemListState = state.itemListState,
                            onAction = onAction,
                        )
                    }

                    is ItemListState.ListEmpty -> {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}

@Composable
private fun HandleEvents(
    events: Flow<ItemListEvents>,
) {
    var dialogModel by remember { mutableStateOf<ErrorAlertDialogModel?>(null) }

    ObserveAsEvents(events = events) { event ->
        when (event) {
            is ItemListEvents.Error -> {
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


class ItemListScreenPreviewParameterProvider : PreviewParameterProvider<ItemListUIState> {
    private val listItems =
        (1..20).map { Item(id = it.toString(), name = "Item $it", isFavorite = false) }

    override val values = sequenceOf(
        ItemListUIState(
            itemListState = ItemListState.ListEmpty,
            isLoading = true,
        ),
        ItemListUIState(
            itemListState = ItemListState.ListEmpty,
            isLoading = false,
        ),
        ItemListUIState(
            itemListState = ItemListState.ListLoaded(listItems),
            isLoading = false,
        )
    )
}

@Composable
@Preview
private fun ItemListScreenPreview(
    @PreviewParameter(ItemListScreenPreviewParameterProvider::class) state: ItemListUIState,
) {
    ComposeSampleAppTheme {
        ItemListScreen(
            state = state,
            onAction = {},
        )
    }
}
