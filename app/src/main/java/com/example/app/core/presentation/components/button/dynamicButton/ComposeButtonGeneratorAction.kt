package com.example.app.core.presentation.components.button.dynamicButton

import com.example.app.core.presentation.components.button.base.ButtonSize
import com.example.app.core.presentation.components.button.base.ButtonTheme
import com.example.app.core.presentation.components.button.base.ButtonType

interface ComposeButtonGeneratorAction {
    val id: String?
    val title: String
    val theme: ButtonTheme
    val type: ButtonType
    val size: ButtonSize
    val contentDescription: String?
    val isActive: Boolean?
}
