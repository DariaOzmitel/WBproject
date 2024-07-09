package com.example.wbproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.meetingScreenNavGraph(
    meetingListScreenContent: @Composable () -> Unit,
    meetingDetailScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.MeetingsList.route,
        route = Screen.Meetings.route
    ) {
        composable(Screen.MeetingsList.route) {
            meetingListScreenContent()
        }
        composable(Screen.MeetingDetail.route) {
            meetingDetailScreenContent()
        }
    }
}