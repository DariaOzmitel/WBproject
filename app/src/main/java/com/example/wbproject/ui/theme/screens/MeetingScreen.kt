package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MySearchTextField
import com.example.wbproject.ui.theme.molecules.MeetingCardColumn
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalFoundationApi::class
)
@Composable
fun MeetingScreen() {
    val tabList = listOf(
        "ВСЕ ВСТРЕЧИ",
        "АКТИВНЫЕ"
    )
    val pagerState = rememberPagerState(pageCount = { tabList.size })
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
            .verticalScroll(rememberScrollState())
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
            tabList.forEachIndexed { index, title ->
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
                        Text(
                            text = title,
                            style = MeetingTheme.typography.bodyText1
                        )
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension16))
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when (page) {
                0 -> MeetingCardColumn(20)
                1 -> MeetingCardColumn(30)
            }
        }
    }

}



