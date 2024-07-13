package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.wbproject.navigation.Screen

fun NavGraphBuilder.moreScreenNavGraph(
    moreMenuScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    myMeetingScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.MoreMenu.route,
        route = Screen.More.route
    ) {
        composable(Screen.MoreMenu.route) {
            moreMenuScreenContent()
        }
        composable(Screen.Profile.route) {
            profileScreenContent()
        }
        composable(Screen.MyMeetings.route) {
            myMeetingScreenContent()
        }
    }
}