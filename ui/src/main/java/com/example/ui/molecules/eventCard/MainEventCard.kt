package com.example.ui.molecules.eventCard

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
import com.example.data.mockData.mockMeeting
import com.example.domain.model.Meeting
import com.example.ui.elements.chips.EventChipsFlowRow14
import com.example.ui.elements.images.EventAvatar
import com.example.ui.elements.text.TextHeading1
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

private const val MAX_TEXT_LINES = 2
private const val MAX_CHIPS_LINES = 1

@Composable
fun MainEventCard(modifier: Modifier = Modifier, meeting: Meeting) {
    Card(
        modifier = modifier.width(EventTheme.dimensions.dimension320),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column {
            EventAvatar(model = meeting.imageUrl)
            TextHeading1(
                text = meeting.name,
                maxLines = MAX_TEXT_LINES,
                overflow = TextOverflow.Ellipsis
            )
            TextSecondary(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension4),
                text = meeting.date
            )
            meeting.chipsList?.let {
                EventChipsFlowRow14(chips = it, maxLines = MAX_CHIPS_LINES)
            }
        }
    }
}

@Composable
fun MainEventCardRow(modifier: Modifier = Modifier, meeting: List<Meeting>) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8),
        contentPadding = PaddingValues(horizontal = EventTheme.dimensions.dimension16)
    ) {
        items(meeting) {
            MainEventCard(meeting = it)
        }
    }
}

@Preview
@Composable
private fun MainEventCardPreview() {
    MainEventCard(meeting = mockMeeting)
}