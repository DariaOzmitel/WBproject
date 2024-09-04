package com.example.wbproject.navigation

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

    fun navigateToCommunityDetail(communityId: Int) {
        navHostController.navigate(route = ScreenV1.CommunityDetail.getRouteWithArgs(communityId))
    }

    fun navigateToMeetingDetail(meetingId: Int) {
        navHostController.navigate(route = ScreenV1.MeetingDetail.getRouteWithArgs(meetingId))
    }

    fun navigateToEnterPin(phone: String) {
        navHostController.navigate(route = ScreenV1.EnterPin.getRouteWithArgs(phone))
    }

    fun navigateToAddProfile(phone: String) {
        navHostController.navigate(route = ScreenV1.AddProfile.getRouteWithArgs(phone))
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