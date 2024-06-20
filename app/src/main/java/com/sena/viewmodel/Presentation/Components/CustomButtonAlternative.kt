package com.sena.viewmodel.Presentation.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sena.viewmodel.Presentation.theme.ViewModelTheme

@Composable
fun CustomButtonAlternative(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    buttonColor: Color,
    onTap: () -> Unit
) {
    Button(
        modifier = modifier
            .height(ViewModelTheme.dimens.buttonHeightNormal),
        shape = RoundedCornerShape(ViewModelTheme.dimens.roundedShapeNormal),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        onClick = onTap
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically),
            style = MaterialTheme.typography.bodyLarge,
            color = textColor
        )
    }
}

@Preview(name = "CustomButtonAlternativePreview", showBackground = true)
@Composable
fun CustomButtonAlternativePreview() {
    ViewModelTheme {
        CustomButtonAlternative(
            text = "Reset",
            textColor = MaterialTheme.colorScheme.primary,
            buttonColor = MaterialTheme.colorScheme.surface,
            onTap = {}
        )
    }
}
