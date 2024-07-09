package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbproject.R
import com.example.wbproject.navigation.AppNavGraph
import com.example.wbproject.navigation.BottomNavigationItem
import com.example.wbproject.navigation.NavigationItem
import com.example.wbproject.navigation.Screen
import com.example.wbproject.navigation.rememberNavigationState
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.MyTextArguments
import com.example.wbproject.ui.theme.elements.MyText
import com.example.wbproject.ui.theme.molecules.MyTopBar

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        0.0f,
        0.0f,
        0.0f,
        0.0f
    )
}

@Preview
@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    Scaffold(modifier = Modifier.padding(
        start = MeetingTheme.dimensions.dimension16,
        end = MeetingTheme.dimensions.dimension16
    ),
        topBar = {
            val currentRoute = navBackStackEntry?.destination?.route
            val currentNavigationItem =
                NavigationItem.items.firstOrNull { it.screen.route == currentRoute }
            MyTopBar(
                title = currentNavigationItem?.title ?: "",
                canNavigateBack = currentNavigationItem?.addLeftArrow ?: false,
                navigateUp = {
                    navigationState.navHostController.navigateUp()
                },
                rightIconResId = null
            )
        },
        bottomBar = {

            BottomAppBar(
                containerColor = Color.Transparent
            ) {

                val items = listOf(
                    BottomNavigationItem.Meetings,
                    BottomNavigationItem.Community,
                    BottomNavigationItem.More,
                )
                items.forEach { item ->
                    val isSelected = navBackStackEntry?.destination?.hierarchy?.any {
                        it.route == item.screen.route
                    } ?: false

                    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                if (!isSelected) {
                                    navigationState.navigateTo(item.screen.route)
                                }
                            },
                            icon = {
                                if (!isSelected) {
                                    Icon(
                                        painter = painterResource(id = item.iconResId),
                                        contentDescription = null
                                    )
                                } else {
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension8),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        MyText(
                                            myTextArguments = MyTextArguments(
                                                text = item.title,
                                                textStyle = MeetingTheme.typography.bodyText1
                                            )
                                        )
                                        Icon(
                                            painter = painterResource(id = R.drawable.point),
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent,
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
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
                MyMeetingScreen()
            },
            profileScreenContent = {
                ProfileScreen()
            },
            communityDetailScreenContent = {
                CommunityDetailScreen()
            },
            meetingDetailScreenContent = {
                MeetingDetailScreen()
            }
        )
        Box(modifier = Modifier.padding(innerPadding))
    }
}

