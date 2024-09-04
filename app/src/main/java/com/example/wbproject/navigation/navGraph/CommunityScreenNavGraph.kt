package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.wbproject.navigation.ScreenV1

fun NavGraphBuilder.communityScreenNavGraph(
    communityListScreenContent: @Composable () -> Unit,
    communityDetailScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = ScreenV1.CommunityList.route,
        route = ScreenV1.CommunityRoot.route
    ) {
        composable(ScreenV1.CommunityList.route) {
            communityListScreenContent()
        }
        composable(
            route = ScreenV1.CommunityDetail.route,
            arguments = listOf(
                navArgument(name = ScreenV1.KEY_COMMUNITY_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            communityDetailScreenContent()
        }
    }
}