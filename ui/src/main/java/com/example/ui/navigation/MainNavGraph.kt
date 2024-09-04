package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavGraph(
    navHostController: NavHostController,
    splashScreenContent: @Composable () -> Unit,
    selectInterestScreenContent: @Composable () -> Unit,
    selectLocationScreenContent: @Composable () -> Unit,
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
    }
}