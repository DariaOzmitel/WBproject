package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wbproject.navigation.Screen

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
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            splashScreenContent()
        }
        composable(Screen.EnterPhone.route) {
            enterPhoneScreenContent()
        }
        composable(route = Screen.EnterPin.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_PHONE) {
                    type = NavType.StringType
                }
            )
        ) {
            enterPinScreenContent()
        }
        composable(route = Screen.AddProfile.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_PHONE) {
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