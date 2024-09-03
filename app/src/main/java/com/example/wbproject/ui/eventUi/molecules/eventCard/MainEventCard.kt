package com.example.wbproject.ui.eventUi.molecules.eventCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.wbproject.ui.eventUi.elements.chips.EventChipsRow14
import com.example.wbproject.ui.eventUi.elements.images.EventAvatar
import com.example.wbproject.ui.eventUi.elements.text.TextHeading1
import com.example.wbproject.ui.eventUi.elements.text.TextSecondary
import com.example.wbproject.ui.eventUi.theme.EventTheme

private const val MAX_TEXT_LINES = 2

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
                EventChipsRow14(chips = it)
            }
        }
    }
}

@Composable
fun MainEventCardRow(modifier: Modifier = Modifier, meeting: List<Meeting>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8)) {
        items(meeting) {
            MainEventCard(modifier = modifier, meeting = it)
        }
    }
}

@Preview
@Composable
private fun MainEventCardPreview() {
    MainEventCard(meeting = mockMeeting)
}