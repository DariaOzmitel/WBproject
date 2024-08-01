package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.wbproject.navigation.Screen

fun NavGraphBuilder.meetingScreenNavGraph(
    meetingListScreenContent: @Composable () -> Unit,
    meetingDetailScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.MeetingsList.route,
        route = Screen.MeetingsRoot.route
    ) {
        composable(Screen.MeetingsList.route) {
            meetingListScreenContent()
        }
        composable(route = Screen.MeetingDetail.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_MEETING_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            meetingDetailScreenContent()
        }
    }
}