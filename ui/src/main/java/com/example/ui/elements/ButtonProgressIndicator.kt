package com.example.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ui.theme.EventTheme

@Composable
fun ButtonProgressIndicator(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.size(EventTheme.dimensions.dimension22),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = EventTheme.colors.fontColorWhite,
            strokeWidth = EventTheme.dimensions.dimension2
        )
    }
}