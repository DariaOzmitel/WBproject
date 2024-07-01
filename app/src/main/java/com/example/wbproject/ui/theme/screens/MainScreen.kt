package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wbproject.R
import com.example.wbproject.navigation.AppNavGraph
import com.example.wbproject.navigation.NavigationItem
import com.example.wbproject.navigation.NavigationState
import com.example.wbproject.navigation.Screen
import com.example.wbproject.navigation.rememberNavigationState
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.MyAvatarArgs
import com.example.wbproject.ui.theme.arguments.MyTextArguments
import com.example.wbproject.ui.theme.elements.MyAvatar
import com.example.wbproject.ui.theme.elements.MyText
import com.example.wbproject.ui.theme.molecules.MeetingCard

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                MyText(
                    myTextArguments = MyTextArguments(
                        text = "Профиль",
                        textStyle = MeetingTheme.typography.subheading1
                    )
                )
            },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRout = navBackStackEntry?.destination?.route
                val items = listOf(
                    NavigationItem.Profile,
                    NavigationItem.MyMeetings,
                    NavigationItem.Meetings
                )
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRout == item.screen.route,
                        onClick = {
                            navigationState.navigateTo(item.screen.route)
                        },
                        icon = {
                            if (item.iconResId != null) {
                                Icon(
                                    painter = painterResource(id = item.iconResId),
                                    contentDescription = null
                                )
                            }
                        },
                        label = {
                            if (!item.title.isNullOrEmpty()) {
                                MyText(
                                    myTextArguments = MyTextArguments(
                                        text = item.title,
                                        textStyle = MeetingTheme.typography.bodyText1
                                    )
                                )
                            }
                        }
                    )
                }

            }
        }
    ) { innerPadding ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            profileScreenContent = { FirstLesson() },
            myMeetingsScreenContent = { SecondLesson() },
            meetingScreenContent = { MeetingCard() }

        )
        Box(modifier = Modifier.padding(innerPadding))
    }
}