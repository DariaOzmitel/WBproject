package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.data.mockData.mockCommunity
import com.example.domain.model.Community
import com.example.wbproject.R
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.elements.text.TextMetadata1

@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    community: Community,
    onCommunityCardClickListener: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(top = MeetingTheme.dimensions.dimension4)
            .clickable { onCommunityCardClickListener() },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(end = MeetingTheme.dimensions.dimension8)
                    .size(MeetingTheme.dimensions.dimension50)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                model = community.imageUrl ?: DEFAULT_IMAGE_URL,
                contentDescription = null,
            )
            Column {
                TextBody1(
                    modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension8),
                    text = community.name
                )
                TextMetadata1(
                    text = String.format(
                        stringResource(id = R.string.participants_number_template),
                        community.participantsNumber
                    ),
                    color = LightColors.neutralWeak
                )
            }
        }
        HorizontalDivider(
            color = MeetingTheme.colors.neutralLine
        )
    }
}

@Composable
fun CommunityCardColumn(
    modifier: Modifier = Modifier,
    communityList: List<Community>,
    onCommunityCardClickListener: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension16),
    ) {
        items(communityList) { community ->
            CommunityCard(
                modifier = Modifier
                    .height(MeetingTheme.dimensions.dimension68),
                community = community,
                onCommunityCardClickListener = onCommunityCardClickListener
            )
        }
    }
}

@Preview
@Composable
private fun CommunityCardPreview() {
    CommunityCard(
        Modifier
            .fillMaxWidth()
            .height(MeetingTheme.dimensions.dimension68),
        community = mockCommunity
    )
}