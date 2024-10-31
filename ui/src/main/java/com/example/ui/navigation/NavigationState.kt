package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

internal class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(Screen.Main.route) {
                inclusive = false
            }
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

    fun navigateToPeople(communityOrEventId: Int, typeId: Int) {
        navHostController.navigate(
            route = Screen.People.getRouteWithArgs(
                communityOrEventId,
                typeId
            )
        ) {
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
internal fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}