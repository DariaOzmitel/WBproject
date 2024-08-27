package com.example.wbproject.ui.eventUi.elements.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.eventUi.elements.text.TextMedium22
import com.example.wbproject.ui.eventUi.theme.EventTheme

@Composable
fun EventChip22(
    modifier: Modifier = Modifier,
    text: String,
    isPressed: Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .clip(RoundedCornerShape(EventTheme.dimensions.dimension8))
            .background(
                color = when (isPressed) {
                    true -> EventTheme.colors.brandColorPurple
                    false -> EventTheme.colors.neutralOffWhite
                }
            )
            .padding(
                vertical = EventTheme.dimensions.dimension10,
                horizontal = EventTheme.dimensions.dimension12
            ),
        contentAlignment = Alignment.Center
    ) {
        TextMedium22(
            text = text,
            color = when (isPressed) {
                true -> EventTheme.colors.neutralOffWhite
                false -> EventTheme.colors.brandColorPurple
            }
        )
    }
}

@Preview
@Composable
private fun EventChipPreview() {
    EventChip16(text = "Тестирование")
}