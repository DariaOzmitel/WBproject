package com.example.ui.screen.main.mainPage

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockAllInterests
import com.example.data.mockData.mockCommunityList
import com.example.data.mockData.mockListMeetingAlreadyPassed
import com.example.data.mockData.mockListMeetings
import com.example.data.mockData.mockMeeting
import com.example.ui.R
import com.example.ui.elements.SearchBar
import com.example.ui.elements.chips.EventChipsFlowRow16
import com.example.ui.elements.text.TextHeading2
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.molecules.SelectInterestsCard
import com.example.ui.molecules.communityCard.CommunityCardRow
import com.example.ui.molecules.eventCard.EventCardMaxWidth
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.molecules.eventCard.MainEventCardRow
import com.example.ui.theme.EventTheme

@Composable
fun MainPageScreen(
    modifier: Modifier = Modifier,
    onMainEventCardClickListener: (Int) -> Unit,
    onEventCardClickListener: (Int) -> Unit,
    onEventCardMaxWidthClickListener: (Int) -> Unit,
    onProfileClickListener: () -> Unit,
    onSelectInterestButtonClickListener: () -> Unit,
    onCommunityCardClickListener: (Int) -> Unit,
) {
    var searchText by remember {
        mutableStateOf("")
    }
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = EventTheme.dimensions.dimension16,
                    bottom = EventTheme.dimensions.dimension24,
                    end = EventTheme.dimensions.dimension16
                )
        ) {
            item {
                SearchBar(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension20),
                    searchText = searchText,
                    onProfileClickListener = onProfileClickListener
                ) {
                    searchText = it
                }
            }
            item {
                MainEventCardRow(
                    modifier = Modifier
                        .padding(bottom = EventTheme.dimensions.dimension40)
                        .ignoreHorizontalParentPadding(),
                    meetingList = mockListMeetings
                ) {
                    onMainEventCardClickListener(it)
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.upcomingMeetings)
                )
            }
            item {
                EventCardRow(
                    modifier = Modifier
                        .padding(bottom = EventTheme.dimensions.dimension40)
                        .ignoreHorizontalParentPadding(),
                    meetings = mockListMeetingAlreadyPassed,
                    onEventCardClickListener = { onEventCardClickListener(it) }
                )
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.testerCommunities)
                )
            }
            item {
                CommunityCardRow(
                    modifier = Modifier
                        .padding(bottom = EventTheme.dimensions.dimension40)
                        .ignoreHorizontalParentPadding(),
                    communities = mockCommunityList
                ) {
                    onCommunityCardClickListener(it)
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.other_meetings)
                )
            }
            item {
                EventChipsFlowRow16(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                    chips = mockAllInterests
                )
            }
            item {
                EventCardMaxWidth(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                    meeting = mockMeeting
                ) {
                    onEventCardMaxWidthClickListener(it)
                }
            }
            item {
                EventCardMaxWidth(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                    meeting = mockMeeting
                ) {
                    onEventCardMaxWidthClickListener(it)
                }
            }
            item {
                EventCardMaxWidth(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                    meeting = mockMeeting
                ) {
                    onEventCardMaxWidthClickListener(it)
                }
            }
            item {
                SelectInterestsCard(
                    modifier = Modifier.padding(
                        bottom = EventTheme.dimensions.dimension40
                    )
                ) {
                    onSelectInterestButtonClickListener()
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainPageScreenPreview() {
    MainPageScreen(
        onMainEventCardClickListener = {},
        onEventCardClickListener = {},
        onProfileClickListener = {},
        onEventCardMaxWidthClickListener = {},
        onSelectInterestButtonClickListener = {},
        onCommunityCardClickListener = {})
}