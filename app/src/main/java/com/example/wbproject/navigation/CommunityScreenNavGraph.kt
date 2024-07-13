package com.example.wbproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.communityScreenNavGraph(
    communityListScreenContent: @Composable () -> Unit,
    communityDetailScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.CommunityList.route,
        route = Screen.Community.route
    ) {
        composable(Screen.CommunityList.route) {
            communityListScreenContent()
        }
        composable(Screen.CommunityDetail.route) {
            communityDetailScreenContent()
        }
    }
}