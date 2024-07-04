package com.example.wbproject.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

object MeetingTheme {
    val colors: MeetingColors
        @Composable get() = LocalColors.current
    val typography: MeetingTypography
        @Composable get() = LocalTypography.current
    val dimensions: MeetingDimensions
        @Composable get() = LocalDimensions.current
}

@Composable
fun MeetingTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides LightColors,
        LocalTypography provides MeetingTypographyValue,
        LocalDimensions provides MeetingDimensionsValue,
    ) {
        MaterialTheme(
            content = content
        )
    }
}
