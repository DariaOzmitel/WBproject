package com.example.wbproject.ui.eventUi.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.data.mockData.mockCommunity
import com.example.domain.model.Community
import com.example.wbproject.ui.eventUi.elements.buttons.SubscribeButton
import com.example.wbproject.ui.eventUi.elements.images.CommunityAvatar
import com.example.wbproject.ui.eventUi.elements.text.TextHeading4
import com.example.wbproject.ui.eventUi.theme.EventTheme

private const val TEXT_MAX_LINES = 1

@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    community: Community,
    width: Dp = EventTheme.dimensions.dimension104,
    subscribeStatus: Boolean = false,
    onCommunityCardClickListener: () -> Unit = {},
    onButtonClickListener: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(width)
            .clickable { onCommunityCardClickListener() },
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension4)
    ) {
        CommunityAvatar(model = community.imageUrl, modifier = Modifier.size(width))
        TextHeading4(
            text = community.name,
            maxLines = TEXT_MAX_LINES,
            overflow = TextOverflow.Ellipsis
        )
        SubscribeButton(
            modifier = Modifier.height(EventTheme.dimensions.dimension38),
            subscribeStatus = subscribeStatus,
            onClick = onButtonClickListener
        )
    }
}

@Composable
fun CommunityCardRow(communities: List<Community>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8)) {
        items(communities) {
            CommunityCard(community = it)
        }
    }
}

@Preview
@Composable
private fun CommunityCardPreview() {
    CommunityCard(community = mockCommunity)
}