package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.wbproject.navigation.ScreenV1

fun NavGraphBuilder.meetingScreenNavGraph(
    meetingListScreenContent: @Composable () -> Unit,
    meetingDetailScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = ScreenV1.MeetingsList.route,
        route = ScreenV1.MeetingsRoot.route
    ) {
        composable(ScreenV1.MeetingsList.route) {
            meetingListScreenContent()
        }
        composable(
            route = ScreenV1.MeetingDetail.route,
            arguments = listOf(
                navArgument(name = ScreenV1.KEY_MEETING_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            meetingDetailScreenContent()
        }
    }
}