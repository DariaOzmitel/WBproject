package com.example.ui.elements.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockAllInterests
import com.example.domain.model.Interest
import com.example.ui.R
import com.example.ui.elements.text.TextMedium22
import com.example.ui.theme.EventTheme
import com.example.ui.theme.NoRippleTheme

@Composable
fun EventChip22(
    modifier: Modifier = Modifier,
    text: String,
    isPressed: Boolean = false,
    onClick: () -> Unit = {}
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
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
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EventChipsRow22(modifier: Modifier = Modifier, chips: List<Interest>) {
    FlowRow(
        modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8),
    ) {
        chips.forEach {
            EventChip22(
                text = it.name,
                modifier = Modifier.padding(end = EventTheme.dimensions.dimension8)
            )
        }
    }
}

@Preview
@Composable
private fun EventChip22Preview() {
    EventChip22(text = stringResource(id = R.string.design))
}

@Preview
@Composable
private fun EventChipsRow22Preview() {
    EventChipsRow22(chips = mockAllInterests)
}