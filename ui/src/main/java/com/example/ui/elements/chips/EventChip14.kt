package com.example.ui.elements.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockInterests
import com.example.domain.model.Interest
import com.example.ui.R
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

@Composable
internal fun EventChip14(
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventChipsFlowRow14(
    modifier: Modifier = Modifier,
    chips: List<Interest>,
    maxLines: Int = Int.MAX_VALUE
) {
    FlowRow(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension10),
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension10),
        maxLines = maxLines
    ) {
        chips.forEach {
            EventChip14(
                text = it.name
            )
        }
    }
}

@Preview
@Composable
private fun EventChip14Preview() {
    EventChip14(text = stringResource(id = R.string.testing))
}

@Preview
@Composable
private fun EventChipsFlowRow14Preview() {
    EventChipsFlowRow14(chips = mockInterests)
}
