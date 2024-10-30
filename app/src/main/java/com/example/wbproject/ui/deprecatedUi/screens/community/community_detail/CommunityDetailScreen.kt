package com.example.wbproject.ui.theme.deprecatedUi.screens.community.community_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.mockData.mockCommunity
import com.example.data.mockData.mockListEvents
import com.example.domain.model.Community
import com.example.domain.model.Event
import com.example.ui.elements.ProgressIndicator
import com.example.wbproject.R
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextBody1
import com.example.wbproject.ui.theme.deprecatedUi.molecules.MeetingCard
import com.example.wbproject.ui.theme.deprecatedUi.molecules.TextForDescription
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme
import org.koin.androidx.compose.koinViewModel

private const val TEXT_MAX_LINE = 13

@Composable
fun CommunityDetailScreen(
    modifier: Modifier = Modifier,
    onMeetingCardClickListener: (Int) -> Unit
) {
    val viewModel: CommunityDetailViewModel = koinViewModel()
    val communityDetailState by viewModel.getCommunityDetailFlow().collectAsStateWithLifecycle()
    var fullText by rememberSaveable {
        mutableStateOf(false)
    }
    when (val state = communityDetailState) {
        is CommunityDetailState.Loading -> ProgressIndicator()
        is CommunityDetailState.CommunityDetail ->
            CommunityDetailContent(
                modifier = modifier,
                fullText = fullText,
                community = state.community,
                eventList = state.eventList,
                onTextClickListener = { fullText = !fullText },
                onMeetingCardClickListener = onMeetingCardClickListener
            )
    }
}

@Composable
private fun CommunityDetailContent(
    modifier: Modifier = Modifier,
    fullText: Boolean,
    community: Community,
    eventList: List<Event>,
    onTextClickListener: () -> Unit,
    onMeetingCardClickListener: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension106,
                start = MeetingTheme.dimensions.dimension16,
                end = MeetingTheme.dimensions.dimension16,
                bottom = MeetingTheme.dimensions.dimension100,
            )
    ) {
        item {
            TextForDescription(
                fullText = fullText,
                description = community.description,
                textMaxLine = TEXT_MAX_LINE
            ) {
                onTextClickListener()
            }
        }
        item {
            TextBody1(
                modifier = Modifier.padding(
                    bottom = MeetingTheme.dimensions.dimension20
                ),
                text = stringResource(id = R.string.community_meetings),
                color = MeetingTheme.colors.neutralWeak,
            )
        }
        items(eventList) { meeting ->
            MeetingCard(
                modifier = Modifier
                    .padding(bottom = MeetingTheme.dimensions.dimension16)
                    .height(MeetingTheme.dimensions.dimension88),
                event = meeting,
                onMeetingCardClickListener = onMeetingCardClickListener
            )
        }
    }
}

@Preview
@Composable
fun CommunityDetailScreenPreview() {
    CommunityDetailContent(
        fullText = false,
        community = mockCommunity,
        eventList = mockListEvents,
        onTextClickListener = { }) {
    }
}