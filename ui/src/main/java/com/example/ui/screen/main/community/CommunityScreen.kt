package com.example.ui.screen.main.community

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.data.mockData.mockCommunity
import com.example.data.mockData.mockListMeetings
import com.example.data.mockData.mockMeeting
import com.example.data.mockData.mockUserList
import com.example.ui.R
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.chips.EventChipsFlowRow16
import com.example.ui.elements.images.CommunityAvatar
import com.example.ui.elements.text.TextHeading1
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextSecondary
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.PeopleAvatarsRow
import com.example.ui.molecules.eventCard.EventCardMaxWidth
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.theme.EventTheme

@Composable
fun CommunityScreen(modifier: Modifier = Modifier) {
    val community = mockCommunity
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
                CustomTopBar(modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    heading = community.name,
                    onLeftIconClickListener = {},
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
                        chips = it
                    )
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
                    avatars = mockUserList.map { it.avatarModel.toString() })
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
                    meeting = mockMeeting
                )
            }
            item {
                EventCardMaxWidth(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    meeting = mockMeeting
                )
            }
            item {
                EventCardMaxWidth(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                    meeting = mockMeeting
                )
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
                    meetings = mockListMeetings
                )
            }
        }
    }
}