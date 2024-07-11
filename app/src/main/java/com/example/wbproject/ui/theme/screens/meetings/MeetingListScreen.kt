package com.example.wbproject.ui.theme.screens.meetings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.domain.TabsForMeetingList
import com.example.wbproject.ui.theme.elements.MySearchTextField
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.molecules.MeetingCardColumn
import kotlinx.coroutines.launch

private const val TEST_ALL_MEETINGS_COUNT = 20
private const val TEST_ACTIVE_MEETINGS_COUNT = 3

@OptIn(
    ExperimentalFoundationApi::class
)
@Composable
fun MeetingListScreen(onMeetingCardClickListener: () -> Unit = {}) {

    val pagerState = rememberPagerState(pageCount = { TabsForMeetingList.entries.size })
    val selectedTabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension128,
                start = MeetingTheme.dimensions.dimension16,
                end = MeetingTheme.dimensions.dimension16,
                bottom = MeetingTheme.dimensions.dimension100,
            )
    ) {
        MySearchTextField()
        Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension16))
        TabRow(modifier = Modifier.fillMaxWidth(),
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
            TabsForMeetingList.entries.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = MeetingTheme.colors.brandColorDefault,
                    unselectedContentColor = MeetingTheme.colors.disableTab,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
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
        Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension16))
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) { page ->
            when (page) {
                TabsForMeetingList.ALL_MEETINGS.pageNumber -> MeetingCardColumn(
                    TEST_ALL_MEETINGS_COUNT,
                    onMeetingCardClickListener = onMeetingCardClickListener
                )

                TabsForMeetingList.ACTIVE.pageNumber -> MeetingCardColumn(
                    TEST_ACTIVE_MEETINGS_COUNT,
                    onMeetingCardClickListener = onMeetingCardClickListener
                )
            }
        }
    }
}



