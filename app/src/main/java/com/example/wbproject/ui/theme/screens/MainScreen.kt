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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbproject.R
import com.example.wbproject.navigation.AppNavGraph
import com.example.wbproject.navigation.NavigationItem
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
    var title by rememberSaveable {
        mutableStateOf("Встречи")
    }
    var addArrowLeft by rememberSaveable {
        mutableStateOf(false)
    }
    var rightIconResId: Int? by rememberSaveable {
        mutableStateOf(null)
    }
    Scaffold(modifier = Modifier.padding(
        start = MeetingTheme.dimensions.dimension16,
        end = MeetingTheme.dimensions.dimension16
    ),
        topBar = {
            MyTopBar(title = title, addArrowLeft = addArrowLeft, rightIconResId = rightIconResId)
        },
        bottomBar = {

            BottomAppBar(
                containerColor = Color.Transparent
            ) {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRout = navBackStackEntry?.destination?.route
                val items = listOf(
                    NavigationItem.Meetings,
                    NavigationItem.Community,
                    NavigationItem.More,
                )
                items.forEach { item ->
                    val isSelected = currentRout == item.screen.route
                    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                navigationState.navigateTo(item.screen.route)
                                title = item.title
                                addArrowLeft = false
                                rightIconResId = item.rightIconResId
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
            meetingScreenContent = { MeetingScreen() },
            communityScreenContent = { CommunityScreen() },
            moreScreenContent = { MoreScreen(navigationState) },
            myMeetingScreenContent = {
                MyMeetingScreen()
                title = NavigationItem.MyMeetings.title
                addArrowLeft = true
                rightIconResId = NavigationItem.MyMeetings.rightIconResId
            },
            profileScreenContent = {
                ProfileScreen()
                title = NavigationItem.Profile.title
                addArrowLeft = true
                rightIconResId = NavigationItem.Profile.rightIconResId
            }
        )
        Box(modifier = Modifier.padding(innerPadding))
    }
}

