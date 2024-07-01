package com.example.wbproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    profileScreenContent: @Composable () -> Unit,
    myMeetingsScreenContent: @Composable () -> Unit,
    meetingScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Profile.route
    ) {
        composable(Screen.Profile.route) {
            profileScreenContent()
        }
        composable(Screen.MyMeetings.route) {
            myMeetingsScreenContent()
        }
        composable(Screen.Meetings.route) {
            meetingScreenContent()
        }
    }
}