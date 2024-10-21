package com.example.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ui.theme.EventTheme

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier.size(EventTheme.dimensions.dimension106),
    color: Color = EventTheme.colors.brandColorPurple
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = contentModifier,
            color = color,
            strokeWidth = EventTheme.dimensions.dimension4
        )
    }
}