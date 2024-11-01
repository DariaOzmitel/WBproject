package com.example.ui.screen.main.mainPage

import androidx.compose.foundation.layout.PaddingValues
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.mockData.mockCommunityList
import com.example.data.mockData.mockEvent
import com.example.data.mockData.mockListEventAlreadyPasseds
import com.example.domain.model.Community
import com.example.domain.model.Event
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.SearchBar
import com.example.ui.elements.chips.EventChipsFlowRow16
import com.example.ui.elements.text.TextHeading2
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.mockAllInterests
import com.example.ui.mockListEvents
import com.example.ui.model.InterestUi
import com.example.ui.molecules.SelectInterestsCard
import com.example.ui.molecules.communityCard.CommunityCardRow
import com.example.ui.molecules.eventCard.EventCardMaxWidth
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.molecules.eventCard.MainEventCardRow
import com.example.ui.theme.EventTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MainPageScreen(
    modifier: Modifier = Modifier,
    onMainEventCardClickListener: (Int) -> Unit,
    onEventCardClickListener: (Int) -> Unit,
    onEventCardMaxWidthClickListener: (Int) -> Unit,
    onProfileClickListener: (Boolean) -> Unit,
    onSelectInterestButtonClickListener: () -> Unit,
    onCommunityCardClickListener: (Int) -> Unit,
) {
    val viewModel: MainPageViewModel = koinViewModel()
    val mainPageState by viewModel.getMainPageStateFlow().collectAsStateWithLifecycle()
    when (val state = mainPageState) {
        is MainPageState.Loading -> ProgressIndicator()
        is MainPageState.MainPageDetail -> {
            Scaffold { innerPadding ->
                MainPageScreenContent(
                    modifier = modifier,
                    innerPadding = innerPadding,
                    eventList = state.eventList,
                    communityList = state.communityList,
                    interestsList = state.interestsList,
                    onMainEventCardClickListener = onMainEventCardClickListener,
                    onEventCardClickListener = onEventCardClickListener,
                    onEventCardMaxWidthClickListener = onEventCardMaxWidthClickListener,
                    onProfileClickListener = { onProfileClickListener(state.authorizationStatus) },
                    onSelectInterestButtonClickListener = onSelectInterestButtonClickListener,
                    onChipClickListener = { viewModel.changeUsersInterest(it) },
                    onCommunityCardClickListener = { onCommunityCardClickListener(it) })
            }
        }
    }
}

@Composable
private fun MainPageScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    eventList: List<Event>,
    communityList: List<Community>,
    interestsList: List<InterestUi>,
    onMainEventCardClickListener: (Int) -> Unit,
    onEventCardClickListener: (Int) -> Unit,
    onEventCardMaxWidthClickListener: (Int) -> Unit,
    onProfileClickListener: () -> Unit,
    onSelectInterestButtonClickListener: () -> Unit,
    onChipClickListener: (Int) -> Unit,
    onCommunityCardClickListener: (Int) -> Unit,
) {
    var searchText by remember {
        mutableStateOf("")
    }
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
                eventList = eventList
            ) {
                onMainEventCardClickListener(it)
            }
        }
        item {
            TextHeading2(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                text = stringResource(id = R.string.upcomingMeetings)
            )
            EventCardRow(
                modifier = Modifier
                    .padding(bottom = EventTheme.dimensions.dimension40)
                    .ignoreHorizontalParentPadding(),
                events = mockListEventAlreadyPasseds,
                onEventCardClickListener = { onEventCardClickListener(it) }
            )
        }
        item {
            TextHeading2(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                text = stringResource(id = R.string.testerCommunities)
            )
            CommunityCardRow(
                modifier = Modifier
                    .padding(bottom = EventTheme.dimensions.dimension40)
                    .ignoreHorizontalParentPadding(),
                communities = communityList
            ) {
                onCommunityCardClickListener(it)
            }
        }
        item {
            TextHeading2(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                text = stringResource(id = R.string.other_meetings)
            )
            EventChipsFlowRow16(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                chips = interestsList
            ) {
                onChipClickListener(it)
            }
        }
        item {
            EventCardMaxWidth(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                event = mockEvent
            ) {
                onEventCardMaxWidthClickListener(it)
            }
        }
        item {
            EventCardMaxWidth(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                event = mockEvent
            ) {
                onEventCardMaxWidthClickListener(it)
            }
        }
        item {
            EventCardMaxWidth(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                event = mockEvent
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

@Preview
@Composable
private fun MainPageScreenContentPreview() {
    MainPageScreenContent(
        innerPadding = PaddingValues(),
        eventList = mockListEvents,
        communityList = mockCommunityList,
        interestsList = mockAllInterests,
        onMainEventCardClickListener = {},
        onEventCardClickListener = {},
        onProfileClickListener = {},
        onEventCardMaxWidthClickListener = {},
        onSelectInterestButtonClickListener = {},
        onChipClickListener = {},
        onCommunityCardClickListener = {})
}