package com.example.ui.screen.main.community

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.mockData.mockCommunity
import com.example.data.mockData.mockEvent
import com.example.data.mockData.mockListEvents
import com.example.data.mockData.mockUserList
import com.example.domain.model.Community
import com.example.domain.model.Event
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.chips.EventChipsFlowRow16
import com.example.ui.elements.images.CommunityAvatar
import com.example.ui.elements.text.TextHeading1
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextSecondary
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.mockInterestsUi
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.PeopleAvatarsRow
import com.example.ui.molecules.eventCard.EventCardMaxWidth
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.theme.EventTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CommunityScreen(
    modifier: Modifier = Modifier,
    onLeftIconClickListener: () -> Unit,
    onEventCardMaxWidthClickListener: (Int) -> Unit,
    onAvatarsRowClickListener: (Int) -> Unit, onEventCardClickListener: (Int) -> Unit
) {
    val viewModel: CommunityViewModel = koinViewModel()
    val communityState by viewModel.getCommunityFlow().collectAsStateWithLifecycle()
    when (val state = communityState) {
        is CommunityState.Loading -> ProgressIndicator()
        is CommunityState.CommunityDetail -> {
            Scaffold { innerPadding ->
                CommunityScreenContent(
                    modifier = modifier,
                    innerPadding = innerPadding,
                    community = state.community,
                    eventList = state.eventList,
                    onLeftIconClickListener = onLeftIconClickListener,
                    onAvatarsRowClickListener = onAvatarsRowClickListener,
                    onEventCardMaxWidthClickListener = { onEventCardMaxWidthClickListener(it) },
                    onEventCardClickListener = { onEventCardClickListener(it) }
                )
            }
        }
    }
}

@Composable
private fun CommunityScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    community: Community,
    eventList: List<Event>,
    onLeftIconClickListener: () -> Unit,
    onAvatarsRowClickListener: (Int) -> Unit,
    onEventCardMaxWidthClickListener: (Int) -> Unit,
    onEventCardClickListener: (Int) -> Unit
) {
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
            CustomTopBar(modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                heading = community.name,
                onLeftIconClickListener = onLeftIconClickListener,
                rightIcon = painterResource(
                    id = R.drawable.share,
                ),
                onRightIconClickListener = {})
        }
        item {
            CommunityAvatar(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                model = community.imageUrl,
                size = EventTheme.dimensions.dimension168
            )
        }
        item {
            TextHeading1(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                text = community.name,
            )
        }
        item {
            community.interests?.let {
                EventChipsFlowRow16(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
//                    chips = it
                    chips = mockInterestsUi
                ) {}
            }
        }
        item {
            EventButton(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                text = stringResource(id = R.string.subscribe)
            )
        }
        item {
            TextSecondary(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                text = stringResource(id = R.string.invite_text),
                color = EventTheme.colors.brandColorPurple
            )
        }
        item {
            community.description?.let {
                TextSecondary(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                    text = it
                )
            }
        }
        item {
            TextHeading2(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                text = stringResource(id = R.string.subscribed)
            )
        }
        item {
            PeopleAvatarsRow(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                avatars = mockUserList.map { it.avatarModel.toString() }) {
                onAvatarsRowClickListener(community.id)
            }
        }
        item {
            TextHeading2(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                text = stringResource(id = R.string.events)
            )
        }
        item {
            EventCardMaxWidth(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                event = mockEvent
            ) {
                onEventCardMaxWidthClickListener(it)
            }
        }
        item {
            EventCardMaxWidth(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                event = mockEvent
            ) {
                onEventCardMaxWidthClickListener(it)
            }
        }
        item {
            EventCardMaxWidth(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                event = mockEvent
            ) {
                onEventCardMaxWidthClickListener(it)
            }
        }
        item {
            TextHeading1(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                text = stringResource(id = R.string.past_events)
            )
        }
        item {
            EventCardRow(
                modifier = Modifier.ignoreHorizontalParentPadding(),
                events = eventList,
            ) {
                onEventCardClickListener(it)
            }
        }
    }
}

@Preview
@Composable
private fun CommunityScreenContentPreview() {
    CommunityScreenContent(
        innerPadding = PaddingValues(0.dp),
        community = mockCommunity,
        eventList = mockListEvents,
        onLeftIconClickListener = {},
        onEventCardMaxWidthClickListener = {},
        onAvatarsRowClickListener = {}) {

    }
}