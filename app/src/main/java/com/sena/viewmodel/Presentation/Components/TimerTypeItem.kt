package com.sena.viewmodel.Presentation.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sena.viewmodel.Presentation.theme.ViewModelTheme

@Composable
fun TimerTypeItem(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    onTap: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(ViewModelTheme.dimens.paddingSmall)
            .clickable { onTap() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}

@Preview(
    name = "TimerTypeItemPreview",
    showBackground = true,
)
@Composable
fun TimerTypeItemPreview() {
    ViewModelTheme {
        TimerTypeItem(
            text = "Focus",
            textColor = MaterialTheme.colorScheme.primary
        )
    }
}