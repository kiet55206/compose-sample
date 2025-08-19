package com.example.app.sampleFeature.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS

@Composable
fun KeyValueItem(
    key: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = key,
            style = MaterialTheme.typography.titleSmall,
        )
        Text(
            modifier = Modifier.weight(1f),
            text = value,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.End,
        )
    }
}

@Composable
@Preview
private fun KeyValueItemPreview() {
    ComposeSampleAppTheme {
        Box(
            modifier = Modifier.background(color = DS.colorScheme.background)
        ) {
            KeyValueItem(key = "Key", value = "Value")
        }
    }
}
