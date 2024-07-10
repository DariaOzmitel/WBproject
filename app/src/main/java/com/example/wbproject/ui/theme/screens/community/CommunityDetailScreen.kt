package com.example.wbproject.ui.theme.screens.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.sp
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.elements.text.TextMetadata1
import com.example.wbproject.ui.theme.molecules.MeetingCard

private const val TEXT_MAX_LINE = 13
private const val MEETINGS_NUM = 6

@Composable
fun CommunityDetailScreen(onMeetingCardClickListener: () -> Unit) {
    var fullText by rememberSaveable {
        mutableStateOf(false)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension128,
                start = MeetingTheme.dimensions.dimension16,
                end = MeetingTheme.dimensions.dimension16,
                bottom = MeetingTheme.dimensions.dimension100,
            )
    ) {
        item {
            TextMetadata1(
                modifier = Modifier.clickable {
                    fullText = !fullText
                },
                text = LoremIpsum(300).values.first(),
                color = MeetingTheme.colors.neutralWeak,
                maxLines = if (!fullText) TEXT_MAX_LINE else Int.MAX_VALUE,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 20.sp
            )
        }
        item {
            TextBody1(
                modifier = Modifier.padding(
                    top = MeetingTheme.dimensions.dimension40,
                    bottom = MeetingTheme.dimensions.dimension20
                ),
                text = stringResource(id = R.string.community_meetings),
                color = MeetingTheme.colors.neutralWeak,
            )
        }
        items(count = MEETINGS_NUM) {
            MeetingCard(
                modifier = Modifier
                    .height(MeetingTheme.dimensions.dimension88),
                onMeetingCardClickListener = onMeetingCardClickListener
            )
        }
    }

}