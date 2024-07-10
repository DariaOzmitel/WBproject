package com.example.wbproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    meetingListScreenContent: @Composable () -> Unit,
    meetingDetailScreenContent: @Composable () -> Unit,
    communityListScreenContent: @Composable () -> Unit,
    moreMenuScreenContent: @Composable () -> Unit,
    myMeetingScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    communityDetailScreenContent: @Composable () -> Unit,
    splashScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            splashScreenContent()
        }
        moreScreenNavGraph(
            moreMenuScreenContent = moreMenuScreenContent,
            profileScreenContent = profileScreenContent,
            myMeetingScreenContent = myMeetingScreenContent
        )
        meetingScreenNavGraph(
            meetingListScreenContent = meetingListScreenContent,
            meetingDetailScreenContent = meetingDetailScreenContent
        )
        communityScreenNavGraph(
            communityListScreenContent = communityListScreenContent,
            communityDetailScreenContent = communityDetailScreenContent
        )
    }
}