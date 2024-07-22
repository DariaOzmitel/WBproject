package com.example.wbproject.ui.theme.screens.more.my_meetings

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.ProgressIndicator
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.items.TabsForMyMeetingList
import com.example.wbproject.ui.theme.molecules.MeetingCardColumn
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(
    ExperimentalFoundationApi::class
)
@Composable
fun MyMeetingScreen(modifier: Modifier = Modifier, onMeetingCardClickListener: () -> Unit) {
    val viewModel: MyMeetingViewModel = koinViewModel()
    val myMeetingState by viewModel.getMyMeetingFlow().collectAsState()
    val pagerState = rememberPagerState(pageCount = { TabsForMyMeetingList.entries.size })
    val selectedTabIndex = pagerState.currentPage
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
            TabsForMyMeetingList.entries.forEach { tab ->
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
            when (val state = myMeetingState) {
                is MyMeetingState.Loading -> ProgressIndicator()
                is MyMeetingState.MyMeetingLists ->
                    when (page) {
                        TabsForMyMeetingList.PLANNED.ordinal ->
                            state.meetingListPlanned?.let {
                                MeetingCardColumn(
                                    meetingList = it,
                                    onMeetingCardClickListener = onMeetingCardClickListener
                                )
                            }

                        TabsForMyMeetingList.ALREADY_PASSED.ordinal ->
                            state.meetingListAlreadyPassed?.let {
                                MeetingCardColumn(
                                    meetingList = it,
                                    isEnded = true,
                                    onMeetingCardClickListener = onMeetingCardClickListener
                                )
                            }
                    }
            }
        }
    }
}

@Preview
@Composable
fun MyMeetingScreenPreview() {
    MyMeetingScreen {
    }
}