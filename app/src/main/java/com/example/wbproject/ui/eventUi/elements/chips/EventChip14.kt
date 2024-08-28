package com.example.wbproject.ui.eventUi.elements.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.eventUi.elements.text.TextSecondary
import com.example.wbproject.ui.eventUi.theme.EventTheme

@Composable
fun EventChip14(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(EventTheme.dimensions.dimension8))
            .background(color = EventTheme.colors.neutralOffWhite)
            .padding(
                vertical = EventTheme.dimensions.dimension2,
                horizontal = EventTheme.dimensions.dimension6
            ),
        contentAlignment = Alignment.Center
    ) {
        TextSecondary(
            text = text,
            color = EventTheme.colors.brandColorPurple
        )
    }
}

@Preview
@Composable
private fun EventChip14Preview() {
    EventChip14(text = stringResource(id = R.string.testing))
}