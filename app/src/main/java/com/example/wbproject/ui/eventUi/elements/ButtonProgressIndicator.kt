package com.example.wbproject.ui.eventUi.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.wbproject.ui.eventUi.theme.EventTheme
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

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
            strokeWidth = MeetingTheme.dimensions.dimension2
        )
    }
}