package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.wbproject.ui.theme.deprecatedUi.theme.EventTypography
import com.example.wbproject.ui.theme.deprecatedUi.theme.EventTypographyValue
import com.example.wbproject.ui.theme.deprecatedUi.theme.LocalEventTypography

object EventTheme {
    val colors: EventColors
        @Composable get() = LocalColors.current
    val typography: EventTypography
        @Composable get() = LocalEventTypography.current
    val dimensions: EventDimensions
        @Composable get() = LocalDimensions.current
}

@Composable
fun EventTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides LightColors,
        LocalEventTypography provides EventTypographyValue,
        LocalDimensions provides EventDimensionsValue,
    ) {
        MaterialTheme(
            content = content
        )
    }
}
