package com.example.ui.navigation

sealed class Screen(
    val route: String
) {
    object Splash : Screen(ROUTE_SPLASH)
    object SelectInterest : Screen(ROUTE_SELECT_INTEREST)
    object SelectLocation : Screen(ROUTE_SELECT_LOCATION)

    companion object {
        private const val ROUTE_SPLASH = "splash"
        private const val ROUTE_SELECT_INTEREST = "selectInterest"
        private const val ROUTE_SELECT_LOCATION = "selectLocation"
    }
}