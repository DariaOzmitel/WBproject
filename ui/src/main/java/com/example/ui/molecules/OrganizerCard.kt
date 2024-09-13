package com.example.ui.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockCommunity
import com.example.domain.model.Community
import com.example.ui.elements.images.CommunityAvatar
import com.example.ui.elements.text.TextHeading4
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

private const val ORGANIZER_NAME_MAX_LINES = 1
private const val ORGANIZER_DESCRIPTION_MAX_LINES = 5

@Composable
internal fun OrganizerCard(
    modifier: Modifier = Modifier,
    organizer: Community
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = EventTheme.dimensions.dimension10)
        ) {
            TextHeading4(
                text = organizer.name,
                maxLines = ORGANIZER_NAME_MAX_LINES,
                overflow = TextOverflow.Ellipsis
            )
            organizer.description?.let {
                TextSecondary(
                    text = it,
                    maxLines = ORGANIZER_DESCRIPTION_MAX_LINES,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        organizer.imageUrl?.let {
            CommunityAvatar(model = it)
        }
    }
}

@Preview
@Composable
private fun OrganizerCardPreview() {
    OrganizerCard(organizer = mockCommunity)
}