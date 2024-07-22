package com.example.wbproject.ui.theme.screens.meetings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MySearchTextField
import com.example.wbproject.ui.theme.elements.ProgressIndicator
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.items.TabsForMeetingList
import com.example.wbproject.ui.theme.molecules.MeetingCardColumn
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(
    ExperimentalFoundationApi::class
)
@Composable
fun MeetingListScreen(modifier: Modifier = Modifier, onMeetingCardClickListener: () -> Unit = {}) {

    var searchText by remember {
        mutableStateOf("")
    }
    val pagerState = rememberPagerState(pageCount = { TabsForMeetingList.entries.size })
    val selectedTabIndex = pagerState.currentPage
    val viewModel: MeetingListViewModel = koinViewModel()
    val meetingState by viewModel.getMeetingListFlow().collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension106,
                start = MeetingTheme.dimensions.dimension16,
                end = MeetingTheme.dimensions.dimension16,
                bottom = MeetingTheme.dimensions.dimension100,
            )
    ) {
        MySearchTextField(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension16),
            searchText = searchText,
            onValueChange = { searchText = it })
        TabRow(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MeetingTheme.dimensions.dimension16),
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            divider = {},
            indicator = { tabPosition ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPosition[selectedTabIndex]),
                    color = MeetingTheme.colors.brandColorDefault
                )
            }
        ) {
            TabsForMeetingList.entries.forEach { tab ->
                Tab(
                    selected = selectedTabIndex == tab.ordinal,
                    selectedContentColor = MeetingTheme.colors.brandColorDefault,
                    unselectedContentColor = MeetingTheme.colors.disableTab,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(tab.ordinal)
                        }
                    },
                    text = {
                        TextBody1(
                            text = stringResource(id = tab.titleResId),
                        )
                    }
                )
            }
        }
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) { page ->
            when (val state = meetingState) {
                is MeetingListState.Loading -> ProgressIndicator()
                is MeetingListState.MeetingList ->
                    when (page) {
                        TabsForMeetingList.ALL_MEETINGS.ordinal -> MeetingCardColumn(
                            meetingList = state.list,
                            onMeetingCardClickListener = onMeetingCardClickListener
                        )

                        TabsForMeetingList.ACTIVE.ordinal -> MeetingCardColumn(
                            meetingList = state.list,
                            onMeetingCardClickListener = onMeetingCardClickListener
                        )
                    }
            }
        }
    }
}



