package com.example.ui.elements.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.TextPrimary
import com.example.ui.theme.EventTheme
import com.example.ui.theme.NoRippleConfiguration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventTextButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    color: Color = Color.Unspecified,
    onClick: () -> Unit = {},
) {
    CompositionLocalProvider(LocalRippleConfiguration provides NoRippleConfiguration) {
        TextButton(
            onClick = onClick, modifier = modifier
                .fillMaxWidth(),
            enabled = enabled,
            shape = RoundedCornerShape(0.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Unspecified,
                contentColor = color,
            ),
            contentPadding = PaddingValues(vertical = EventTheme.dimensions.dimension16)
        ) {
            TextPrimary(text = text)
        }
    }
}

@Preview
@Composable
private fun EventButtonPreview() {
    EventTextButton(text = stringResource(id = R.string.say_later))
}