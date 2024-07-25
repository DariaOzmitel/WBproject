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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.data.mockData.mockListMeetings
import com.example.domain.model.Meeting
import com.example.wbproject.R
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MyChipRow
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.elements.text.TextMetadata1
import com.example.wbproject.ui.theme.elements.text.TextMetadata2

const val DEFAULT_IMAGE_URL =
    "https://s3-alpha-sig.figma.com/img/fefc/cf31/614b29f37235f304b6fe5c0562c7e733?Expires=1722211200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=WFu5spPuKKjYMP5WG0IGXa07nr7R4qrbgZqbHgLUMRAaI-6d6rfxvb6BNbgrG47rFQQhWiQ94aubIvo7iR48lPlqMCuaEvGwktbZfIzvFNjOokucsblC-DBf6uvWjwiv-CSb377dPbRUQoU~1cRQIcSUfrLox7rtUW-s1JytjT43b0v9BZGM9ZZi3lCDNTyF1VPTObVtVaGlipwN1KdlDD92we-GNh90wyPApZOZqI3i2GSA1KHHbdm7Q9KKzPFpZC33y7mEGPuYiMioCmRdsANa5qYfztnUe2gM46ODGbQbTFUNQeatx~pgoWaxNnNsIbvKV6tO3rs5ft3VlY09hA__"

@Composable
fun MeetingCard(
    modifier: Modifier = Modifier,
    meeting: Meeting,
    isEnded: Boolean = false,
    onMeetingCardClickListener: () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable { onMeetingCardClickListener() },
        shape = RectangleShape, colors = CardDefaults.cardColors(
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
                model = meeting.imageUrl ?: DEFAULT_IMAGE_URL,
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .height(MeetingTheme.dimensions.dimension68)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextBody1(
                    text = meeting.name
                )
                TextMetadata1(
                    text = stringResource(
                        id = R.string.date_city_template,
                        meeting.date,
                        meeting.city
                    ),
                    color = LightColors.neutralWeak,
                )
                MyChipRow()
            }
            if (isEnded) {
                TextMetadata2(
                    text = stringResource(id = R.string.ended),
                    color = MeetingTheme.colors.neutralWeak
                )
            }
        }
        HorizontalDivider(
            color = MeetingTheme.colors.neutralLine
        )
    }
}

@Composable
fun MeetingCardColumn(
    modifier: Modifier = Modifier,
    meetingList: List<Meeting>,
    isEnded: Boolean = false,
    onMeetingCardClickListener: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension16),
    ) {
        items(meetingList) { meeting ->
            MeetingCard(
                modifier = Modifier
                    .height(MeetingTheme.dimensions.dimension88),
                meeting = meeting,
                isEnded = isEnded,
                onMeetingCardClickListener
            )
        }
    }
}

@Preview
@Composable
private fun MeetingCardPreview() {
    MeetingCard(
        modifier = Modifier
            .height(MeetingTheme.dimensions.dimension88)
            .fillMaxWidth(),
        meeting = mockListMeetings[0]
    )
}