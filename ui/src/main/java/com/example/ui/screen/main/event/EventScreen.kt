package com.example.ui.screen.main.event

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.data.mockData.mockCommunity
import com.example.data.mockData.mockListMeetingAlreadyPassed
import com.example.data.mockData.mockPresenter
import com.example.data.mockData.mockUserList
import com.example.domain.model.Meeting
import com.example.ui.MetroStation
import com.example.ui.R
import com.example.ui.elements.MetroStationRow
import com.example.ui.elements.chips.EventChipsFlowRow16
import com.example.ui.elements.images.EventAvatar
import com.example.ui.elements.images.MapImage
import com.example.ui.elements.text.TextHeading1
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextSecondary
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.EventBottomBar
import com.example.ui.molecules.OrganizerCard
import com.example.ui.molecules.PeopleAvatarsRow
import com.example.ui.molecules.PresenterCard
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.theme.EventTheme

@Composable
fun EventScreen(modifier: Modifier = Modifier, meeting: Meeting) {
    Scaffold { innerPadding ->
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
                        heading = meeting.name,
                        onLeftIconClickListener = {},
                        rightIcon = painterResource(
                            id = R.drawable.share,
                        ),
                        onRightIconClickListener = {})
                }
                item {
                    EventAvatar(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                        model = meeting.imageUrl,
                        height = EventTheme.dimensions.dimension268
                    )
                }
                item {
                    TextHeading1(text = meeting.name)
                }
                item {
                    TextSecondary(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                        text = meeting.date
                    )
                }
                item {
                    meeting.chipsList?.let {
                        EventChipsFlowRow16(
                            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                            chips = it
                        )
                    }
                }
                item {
                    meeting.description?.let {
                        TextSecondary(
                            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                            text = it
                        )
                    }
                }
                item {
                    TextHeading2(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                        text = stringResource(id = R.string.presenter)
                    )
                }
                item {
                    PresenterCard(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                        presenter = mockPresenter
                    )
                }
                item {
                    TextHeading2(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension2),
                        text = meeting.address
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
                        avatars = mockUserList.map { it.avatarModel.toString() })
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
                    )
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
                        meetings = mockListMeetingAlreadyPassed
                    )
                }
            }
            EventBottomBar(placesCount = 30)
        }
    }
}