package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            launchSingleTop = true
            restoreState = true
        }
    }
    fun navigateToEvent(eventId: Int) {
        navHostController.navigate(route = Screen.Event.getRouteWithArgs(eventId)) {
//            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToCommunity(communityId: Int) {
        navHostController.navigate(route = Screen.Community.getRouteWithArgs(communityId)) {
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}