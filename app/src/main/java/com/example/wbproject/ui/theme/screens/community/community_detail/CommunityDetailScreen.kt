package com.example.wbproject.ui.theme.screens.community.community_detail

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
import com.example.data.mockData.mockListMeetings
import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.ProgressIndicator
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.molecules.MeetingCard
import com.example.wbproject.ui.theme.molecules.TextForDescription
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

private const val TEXT_MAX_LINE = 13

@Composable
fun CommunityDetailScreen(
    modifier: Modifier = Modifier,
    communityId: Int,
    onMeetingCardClickListener: (Int) -> Unit
) {
    val viewModel: CommunityDetailViewModel = koinViewModel { parametersOf(communityId) }
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
                meetingList = state.meetingList,
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
    meetingList: List<Meeting>,
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
        items(meetingList) { meeting ->
            MeetingCard(
                modifier = Modifier
                    .padding(bottom = MeetingTheme.dimensions.dimension16)
                    .height(MeetingTheme.dimensions.dimension88),
                meeting = meeting,
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
        meetingList = mockListMeetings,
        onTextClickListener = { }) {
    }
}