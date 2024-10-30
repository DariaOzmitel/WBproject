package com.example.ui.molecules.eventCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.ui.elements.text.TextHeading3
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

private const val MAX_TEXT_LINES = 2
private const val MAX_CHIPS_LINES = 1

@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    event: Event,
    onEventCardClickListener: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .width(EventTheme.dimensions.dimension212)
            .clickable {
                onEventCardClickListener(event.id)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column {
            EventAvatar(model = event.imageUrl, height = EventTheme.dimensions.dimension148)
            TextHeading3(
                text = event.name,
                maxLines = MAX_TEXT_LINES,
                overflow = TextOverflow.Ellipsis
            )
            TextSecondary(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension4),
                text = event.date
            )
            event.chipsList?.let {
                EventChipsFlowRow14(chips = it, maxLines = MAX_CHIPS_LINES)
            }
        }
    }
}

@Composable
fun EventCardRow(
    modifier: Modifier = Modifier,
    events: List<Event>,
    onEventCardClickListener: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8),
        contentPadding = PaddingValues(horizontal = EventTheme.dimensions.dimension16)
    ) {
        items(events) { meeting ->
            EventCard(event = meeting) {
                onEventCardClickListener(meeting.id)
            }
        }
    }
}

@Preview
@Composable
private fun EventCardPreview() {
    EventCard(event = mockEvent) {}
}