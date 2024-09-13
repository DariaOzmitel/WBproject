package com.example.ui.molecules.eventCard

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
import com.example.data.mockData.mockMeeting
import com.example.domain.model.Meeting
import com.example.ui.elements.chips.EventChipsRow14
import com.example.ui.elements.images.EventAvatar
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

private const val MAX_TEXT_LINES = 2

@Composable
internal fun EventCardMaxWidth(modifier: Modifier = Modifier, meeting: Meeting) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column {
            EventAvatar(model = meeting.imageUrl, height = EventTheme.dimensions.dimension180)
            TextHeading2(
                text = meeting.name,
                maxLines = MAX_TEXT_LINES,
                overflow = TextOverflow.Ellipsis
            )
            TextSecondary(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension6),
                text = meeting.date
            )
            meeting.chipsList?.let {
                EventChipsRow14(chips = it)
            }
        }
    }
}

@Preview
@Composable
private fun EventCardMaxWidthPreview() {
    EventCardMaxWidth(meeting = mockMeeting)
}