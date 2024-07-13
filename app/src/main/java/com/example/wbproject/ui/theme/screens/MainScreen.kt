package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbproject.R
import com.example.wbproject.navigation.AppNavGraph
import com.example.wbproject.navigation.NavigationItem
import com.example.wbproject.navigation.Screen
import com.example.wbproject.navigation.rememberNavigationState
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.molecules.MyBottomAppBar
import com.example.wbproject.ui.theme.molecules.MyTopBar

@Preview
@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isTopBarVisible = currentRoute != Screen.Splash.route
    val isBottomBarVisible = currentRoute != Screen.Splash.route

    Scaffold(modifier = Modifier.padding(
        start = MeetingTheme.dimensions.dimension16,
        end = MeetingTheme.dimensions.dimension16
    ),
        topBar = {
            if (isTopBarVisible) {
                val currentNavigationItem =
                    NavigationItem.items.firstOrNull { it.screen.route == currentRoute }
                MyTopBar(
                    title = stringResource(
                        id = currentNavigationItem?.titleResId ?: R.string.meetings
                    ),
                    canNavigateBack = currentNavigationItem?.addLeftArrow ?: false,
                    navigateUp = {
                        navigationState.navHostController.navigateUp()
                    },
                    rightIconResId = null
                )
            }
        },
        bottomBar = {
            if (isBottomBarVisible) {
                MyBottomAppBar(
                    navBackStackEntry = navBackStackEntry,
                    navigationState = navigationState
                )
            }
        }
    ) { innerPadding ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            splashScreenContent = {
                SplashScreen(
                    animationEndListener = { navigationState.navigateTo(Screen.MeetingsList.route) }
                )
            },
            meetingListScreenContent = {
                MeetingListScreen(
                    onMeetingCardClickListener = { navigationState.navigateTo(Screen.MeetingDetail.route) }
                )
            },
            communityListScreenContent = {
                CommunityListScreen(
                    onCommunityCardClickListener =
                    { navigationState.navigateTo(Screen.CommunityDetail.route) }
                )
            },
            moreMenuScreenContent = {
                MoreScreen(
                    onProfileItemClickListener = {
                        navigationState.navigateTo(Screen.Profile.route)
                    },
                    onMyMeetingsItemClickListener = {
                        navigationState.navigateTo(Screen.MyMeetings.route)
                    }
                )
            },
            myMeetingScreenContent = {
                MyMeetingScreen(
                    onMeetingCardClickListener = {
                        navigationState.navigateTo(
                            Screen.MeetingDetail.route
                        )
                    }
                )
            },
            profileScreenContent = {
                ProfileScreen()
            },
            communityDetailScreenContent = {
                CommunityDetailScreen(onMeetingCardClickListener = {
                    navigationState.navigateTo(
                        Screen.MeetingDetail.route
                    )
                })
            },
            meetingDetailScreenContent = {
                MeetingDetailScreen()
            }
        )
        Box(modifier = Modifier.padding(innerPadding))
    }
}

