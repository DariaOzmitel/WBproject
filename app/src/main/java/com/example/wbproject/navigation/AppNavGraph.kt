package com.example.wbproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    meetingScreenContent: @Composable () -> Unit,
    communityScreenContent: @Composable () -> Unit,
    moreScreenContent: @Composable () -> Unit,
    myMeetingScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Meetings.route
    ) {
        composable(Screen.Meetings.route) {
            meetingScreenContent()
        }
        composable(Screen.Community.route) {
            communityScreenContent()
        }
        composable(Screen.More.route) {
            moreScreenContent()
        }
        composable(Screen.Profile.route) {
            profileScreenContent()
        }
        composable(Screen.MyMeetings.route) {
            myMeetingScreenContent()
        }
    }
}