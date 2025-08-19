package com.example.app.core.presentation.components.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable

@Composable
fun LoadingOverlay(
    isLoading: Boolean,
    content: @Composable () -> Unit
) {
    Box {
        content()
        if (isLoading) {
            LoadingView()
        }
    }
}