package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wbproject.ui.theme.MeetingTheme

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier.size(MeetingTheme.dimensions.dimension106),
    color: Color = MeetingTheme.colors.brandColorDefault
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = contentModifier,
            color = color,
            strokeWidth = MeetingTheme.dimensions.dimension4
        )
    }
}