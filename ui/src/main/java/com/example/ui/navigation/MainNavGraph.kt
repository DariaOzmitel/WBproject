package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
internal fun MainNavGraph(
    navHostController: NavHostController,
    splashScreenContent: @Composable () -> Unit,
    selectInterestScreenContent: @Composable () -> Unit,
    selectLocationScreenContent: @Composable () -> Unit,
    mainScreenContent: @Composable () -> Unit,
    eventScreenContent: @Composable () -> Unit,
    peopleScreenContent: @Composable () -> Unit,
    communityScreenContent: @Composable () -> Unit,
    enterNameScreenContent: @Composable () -> Unit,
    enterPhoneScreenContent: @Composable () -> Unit,
    enterPinScreenContent: @Composable () -> Unit,
    confirmedEventScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    editProfileScreenContent: @Composable () -> Unit,
    deleteProfileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            splashScreenContent()
        }
        composable(Screen.SelectInterest.route) {
            selectInterestScreenContent()
        }
        composable(Screen.SelectLocation.route) {
            selectLocationScreenContent()
        }
        composable(Screen.Main.route) {
            mainScreenContent()
        }
        composable(route = Screen.Event.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_EVENT_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            eventScreenContent()
        }
        composable(route = Screen.People.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_COMMUNITY_OR_EVENT_ID) {
                    type = NavType.IntType
                },
                navArgument(name = Screen.KEY_TYPE_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            peopleScreenContent()
        }
        composable(route = Screen.Community.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_COMMUNITY_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            communityScreenContent()
        }
        composable(Screen.EnterName.route) {
            enterNameScreenContent()
        }
        composable(Screen.EnterPhone.route) {
            enterPhoneScreenContent()
        }
        composable(Screen.EnterPin.route) {
            enterPinScreenContent()
        }
        composable(Screen.ConfirmedEvent.route) {
            confirmedEventScreenContent()
        }
        composable(Screen.Profile.route) {
            profileScreenContent()
        }
        composable(Screen.EditProfile.route) {
            editProfileScreenContent()
        }
        composable(Screen.DeleteProfile.route) {
            deleteProfileScreenContent()
        }
    }
}