package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.wbproject.navigation.ScreenV1

fun NavGraphBuilder.moreScreenNavGraph(
    moreMenuScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    myMeetingScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = ScreenV1.MoreMenu.route,
        route = ScreenV1.MoreRoot.route
    ) {
        composable(ScreenV1.MoreMenu.route) {
            moreMenuScreenContent()
        }
        composable(ScreenV1.Profile.route) {
            profileScreenContent()
        }
        composable(ScreenV1.MyMeetings.route) {
            myMeetingScreenContent()
        }
    }
}