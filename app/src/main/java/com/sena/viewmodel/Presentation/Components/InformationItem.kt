package com.sena.viewmodel.Presentation.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.sena.viewmodel.Presentation.theme.ViewModelTheme

@Composable
fun InformationItem(
    modifier: Modifier = Modifier,
    text: String,
    label: String
) {
    Column(
        modifier = modifier.height(ViewModelTheme.dimens.informationItemHeight),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(
    name = "InformationItemPreview",
    showBackground = true,
)
@Composable
fun InformationItemPreview() {
    ViewModelTheme {
        InformationItem(
            text = "5",
            label = "rounds"
        )
    }
}
