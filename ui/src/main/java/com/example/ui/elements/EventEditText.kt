package com.example.ui.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.R
import com.example.ui.elements.text.TextPrimary
import com.example.ui.theme.EventTheme
@Composable
fun EventEditText(
    modifier: Modifier = Modifier,
    hint: String = stringResource(id = R.string.name_and_surname),
    displayText: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit
) {
    val interactionSource: MutableInteractionSource =
        remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    Box(
        modifier = modifier
            .addBorder(isFocused = isFocused)
            .fillMaxWidth()
            .clip(RoundedCornerShape(EventTheme.dimensions.dimension16))
            .background(
                when (isError) {
                    true -> EventTheme.colors.errorBackgroundColor
                    false -> EventTheme.colors.fontColorWhite
                }
            )
            .padding(
                vertical = EventTheme.dimensions.dimension16,
                horizontal = EventTheme.dimensions.dimension12
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = displayText,
            onValueChange = { onValueChange(it) },
            interactionSource = interactionSource,
            singleLine = true,
            textStyle = EventTheme.typography.primary.copy(color = EventTheme.colors.fontColorBlack)
        ) { innerTextField ->
            if (displayText.isBlank()) {
                TextPrimary(text = hint, color = EventTheme.colors.neutralDisabled)
            }
            innerTextField()
        }
    }
}

@Composable
private fun Modifier.addBorder(isFocused: Boolean): Modifier {
    return when (isFocused) {
        true -> {
            this.border(
                border = BorderStroke(
                    width = EventTheme.dimensions.dimension1,
                    color = EventTheme.colors.brandColorPurple
                ), shape = RoundedCornerShape(EventTheme.dimensions.dimension16)
            )
        }
        false -> this
    }
}

@Preview
@Composable
private fun EventEditTextPreview() {
    EventEditText(displayText = "") {}
}