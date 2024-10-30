package com.example.ui.molecules.eventCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockEvent
import com.example.domain.model.Event
import com.example.ui.elements.chips.EventChipsFlowRow14
import com.example.ui.elements.images.EventAvatar
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

private const val MAX_TEXT_LINES = 2
private const val MAX_CHIPS_LINES = 1

@Composable
internal fun EventCardMaxWidth(
    modifier: Modifier = Modifier,
    event: Event,
    onEventCardClickListener: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onEventCardClickListener(event.id)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column {
            EventAvatar(model = event.imageUrl, height = EventTheme.dimensions.dimension180)
            TextHeading2(
                text = event.name,
                maxLines = MAX_TEXT_LINES,
                overflow = TextOverflow.Ellipsis
            )
            TextSecondary(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension6),
                text = event.date
            )
            event.chipsList?.let {
                EventChipsFlowRow14(chips = it, maxLines = MAX_CHIPS_LINES)
            }
        }
    }
}

@Preview
@Composable
private fun EventCardMaxWidthPreview() {
    EventCardMaxWidth(event = mockEvent) {}
}