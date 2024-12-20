package com.example.ui.screen.main.event

import androidx.compose.foundation.layout.Column
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
import com.example.data.mockData.mockListEventAlreadyPasseds
import com.example.data.mockData.mockUserList
import com.example.domain.model.Event
import com.example.ui.MetroStation
import com.example.ui.R
import com.example.ui.elements.MetroStationRow
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.chips.EventChipsFlowRow16
import com.example.ui.elements.images.EventAvatar
import com.example.ui.elements.images.MapImage
import com.example.ui.elements.text.TextHeading1
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextSecondary
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.mockInterestsUi
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.EventBottomBar
import com.example.ui.molecules.OrganizerCard
import com.example.ui.molecules.PeopleAvatarsRow
import com.example.ui.molecules.PresenterCard
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.theme.EventTheme
import org.koin.androidx.compose.koinViewModel

private const val MOCK_PLACE_COUNT = 30

@Composable
internal fun EventScreen(
    modifier: Modifier = Modifier,
    onLeftIconClickListener: () -> Unit,
    onAvatarsRowClickListener: (Int) -> Unit,
    onOrganizerCardClickListener: (Int) -> Unit,
    onButtonClickListener: () -> Unit,
    onEventCardClickListener: (Int) -> Unit
) {
    val viewModel: EventViewModel = koinViewModel()
    val meetingState by viewModel.getMeetingFlow().collectAsStateWithLifecycle()
    when (val state = meetingState) {
        is EventState.Loading -> ProgressIndicator()
        is EventState.EventDetail -> {
            Scaffold { innerPadding ->
                EventScreenContent(
                    modifier = modifier,
                    innerPadding = innerPadding,
                    event = state.event,
                    onLeftIconClickListener = onLeftIconClickListener,
                    onAvatarsRowClickListener = onAvatarsRowClickListener,
                    onOrganizerCardClickListener = { onOrganizerCardClickListener(it) },
                    onButtonClickListener = onButtonClickListener,
                    onEventCardClickListener = { onEventCardClickListener(it) }
                )
            }
        }
    }
}

@Composable
private fun EventScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    event: Event,
    onLeftIconClickListener: () -> Unit,
    onAvatarsRowClickListener: (Int) -> Unit,
    onOrganizerCardClickListener: (Int) -> Unit,
    onButtonClickListener: () -> Unit,
    onEventCardClickListener: (Int) -> Unit
) {
    Column(
        modifier = modifier.padding(
            top = innerPadding.calculateTopPadding(),
            bottom = innerPadding.calculateBottomPadding()
        )
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(
                    start = EventTheme.dimensions.dimension16,
                    end = EventTheme.dimensions.dimension16,
                )
        ) {
            item {
                CustomTopBar(modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    heading = event.name,
                    onLeftIconClickListener = onLeftIconClickListener,
                    rightIcon = painterResource(
                        id = R.drawable.share,
                    ),
                    onRightIconClickListener = {})
            }
            item {
                EventAvatar(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    model = event.imageUrl,
                    height = EventTheme.dimensions.dimension268
                )
            }
            item {
                TextHeading1(text = event.name)
            }
            item {
                TextSecondary(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    text = event.date
                )
            }
            item {
                event.chipsList?.let {
                    EventChipsFlowRow16(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
//                        chips = it
                        chips = mockInterestsUi
                    ) {}
                }
            }
            item {
                event.description?.let {
                    TextSecondary(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                        text = it
                    )
                }
            }
            item {
                event.presenter?.let {
                    TextHeading2(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                        text = stringResource(id = R.string.presenter)
                    )
                    PresenterCard(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                        presenter = it
                    )
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension2),
                    text = event.address
                )
            }
            item {
                MetroStationRow(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension10),
                    metroStation = MetroStation.PRIMORSKAYA
                )
            }
            item {
                MapImage(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                    model = R.drawable.event_map_example
                )
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.go_to_event)
                )
            }
            item {
                PeopleAvatarsRow(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                    avatars = mockUserList.map { it.avatarModel.toString() }) {
                    onAvatarsRowClickListener(event.id)
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.organizer)
                )
            }
            item {
                OrganizerCard(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                    organizer = mockCommunity
                ) {
                    onOrganizerCardClickListener(it)
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.other_community_meetings)
                )
            }
            item {
                EventCardRow(
                    modifier = Modifier
                        .padding(bottom = EventTheme.dimensions.dimension40)
                        .ignoreHorizontalParentPadding(),
                    events = mockListEventAlreadyPasseds
                ) {
                    onEventCardClickListener(it)
                }
            }
        }
        EventBottomBar(placesCount = MOCK_PLACE_COUNT) { onButtonClickListener() }
    }
}

@Preview
@Composable
private fun EventScreenContentPreview() {
    EventScreenContent(
        innerPadding = PaddingValues(0.dp),
        event = mockEvent,
        onLeftIconClickListener = {},
        onOrganizerCardClickListener = {},
        onButtonClickListener = {},
        onAvatarsRowClickListener = {}) {
    }
}