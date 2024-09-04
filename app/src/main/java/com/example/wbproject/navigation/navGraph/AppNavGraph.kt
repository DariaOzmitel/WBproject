package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wbproject.navigation.ScreenV1

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
    enterPhoneScreenContent: @Composable () -> Unit,
    enterPinScreenContent: @Composable () -> Unit,
    addProfileScreenContent: @Composable () -> Unit,
    splashScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = ScreenV1.Splash.route
    ) {
        composable(ScreenV1.Splash.route) {
            splashScreenContent()
        }
        composable(ScreenV1.EnterPhone.route) {
            enterPhoneScreenContent()
        }
        composable(
            route = ScreenV1.EnterPin.route,
            arguments = listOf(
                navArgument(name = ScreenV1.KEY_PHONE) {
                    type = NavType.StringType
                }
            )
        ) {
            enterPinScreenContent()
        }
        composable(
            route = ScreenV1.AddProfile.route,
            arguments = listOf(
                navArgument(name = ScreenV1.KEY_PHONE) {
                    type = NavType.StringType
                }
            )
        ) {
            addProfileScreenContent()
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