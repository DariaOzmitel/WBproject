package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.wbproject.navigation.Screen

fun NavGraphBuilder.communityScreenNavGraph(
    communityListScreenContent: @Composable () -> Unit,
    communityDetailScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.CommunityList.route,
        route = Screen.CommunityRoot.route
    ) {
        composable(Screen.CommunityList.route) {
            communityListScreenContent()
        }
        composable(route = Screen.CommunityDetail.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_COMMUNITY_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            communityDetailScreenContent()
        }
    }
}