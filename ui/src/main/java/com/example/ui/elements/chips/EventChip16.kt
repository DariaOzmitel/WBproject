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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.R
import com.example.ui.elements.text.TextMedium16
import com.example.ui.model.InterestUi
import com.example.ui.theme.EventTheme
import com.example.ui.theme.NoRippleConfiguration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EventChip16(
    modifier: Modifier = Modifier,
    text: String,
    isPressed: Boolean = false,
    onClick: () -> Unit = {}
) {
    CompositionLocalProvider(LocalRippleConfiguration provides NoRippleConfiguration) {
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
                .padding(EventTheme.dimensions.dimension8),
            contentAlignment = Alignment.Center
        ) {
            TextMedium16(
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
internal fun EventChipsFlowRow16(
    modifier: Modifier = Modifier, chips: List<InterestUi>,
    onChipClickListener: (Int) -> Unit
) {
    FlowRow(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension10),
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension10),
    ) {
        chips.forEach {
            EventChip16(
                text = it.name,
                isPressed = it.isSelected
            ) {
                onChipClickListener(it.id)
            }
        }
    }
}

@Preview
@Composable
private fun EventChip16Preview() {
    EventChip16(text = stringResource(id = R.string.testing))
}