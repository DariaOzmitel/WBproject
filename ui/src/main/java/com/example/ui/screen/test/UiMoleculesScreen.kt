package com.example.ui.screen.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.data.mockData.mockCommunity
import com.example.data.mockData.mockCommunityList
import com.example.data.mockData.mockListEvents
import com.example.data.mockData.mockPresenter
import com.example.ui.molecules.PresenterCard
import com.example.ui.molecules.communityCard.CommunityCard
import com.example.ui.molecules.communityCard.CommunityCardRow
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.molecules.eventCard.MainEventCardRow
import com.example.ui.theme.EventTheme

@Composable
internal fun UiMoleculesScreen() {
    var booleanState by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .padding(
                top = EventTheme.dimensions.dimension128,
                start = EventTheme.dimensions.dimension8,
                end = EventTheme.dimensions.dimension8,
                bottom = EventTheme.dimensions.dimension32,
            )
//            .background(EventTheme.colors.neutralDisabled)
        ,
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8)
    ) {
        item {
            CommunityCard(
                community = mockCommunity,
                subscribeStatus = booleanState,
                onButtonClickListener = { booleanState = !booleanState }) {}
        }
        item {
            CommunityCardRow(communities = mockCommunityList)
            Spacer(modifier = Modifier.height(EventTheme.dimensions.dimension8))
        }
        item {
            MainEventCardRow(eventList = mockListEvents, onMainEventCardClickListener = {})
        }
        item {
            EventCardRow(events = mockListEvents) {}
        }
        item {
            PresenterCard(presenter = mockPresenter)
        }
    }
}