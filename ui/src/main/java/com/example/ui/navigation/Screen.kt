package com.example.ui.navigation

internal sealed class Screen(
    val route: String
) {
    object Splash : Screen(ROUTE_SPLASH)
    object SelectInterest : Screen(ROUTE_SELECT_INTEREST)
    object SelectLocation : Screen(ROUTE_SELECT_LOCATION)
    object Main : Screen(ROUTE_MAIN)
    object Event : Screen(ROUTE_EVENT) {

        private const val ROUTE_FOR_ARGS = "event"

        fun getRouteWithArgs(eventId: Int): String {
            return "$ROUTE_FOR_ARGS/$eventId"
        }
    }

    object People : Screen(ROUTE_PEOPLE) {

        private const val ROUTE_FOR_ARGS = "people"

        fun getRouteWithArgs(communityOrEventId: Int, typeId: Int): String {
            return "$ROUTE_FOR_ARGS/$communityOrEventId/$typeId"
        }
    }
    object Community : Screen(ROUTE_COMMUNITY) {

        private const val ROUTE_FOR_ARGS = "community"

        fun getRouteWithArgs(communityId: Int): String {
            return "$ROUTE_FOR_ARGS/$communityId"
        }
    }

    object EnterName : Screen(ROUTE_ENTER_NAME)
    object EnterPhone : Screen(ROUTE_ENTER_PHONE)
    object EnterPin : Screen(ROUTE_ENTER_PIN)
    object ConfirmedEvent : Screen(ROUTE_CONFIRMED_EVENT)
    object Profile : Screen(ROUTE_PROFILE)
    object EditProfile : Screen(ROUTE_EDIT_PROFILE)
    object DeleteProfile : Screen(ROUTE_DELETE_PROFILE)

    companion object {
        const val KEY_EVENT_ID = "event_id"
        const val KEY_COMMUNITY_ID = "community_id"
        const val KEY_COMMUNITY_OR_EVENT_ID = "community_or_event_id"
        const val KEY_TYPE_ID = "type_id"

        private const val ROUTE_SPLASH = "splash"
        private const val ROUTE_SELECT_INTEREST = "selectInterest"
        private const val ROUTE_SELECT_LOCATION = "selectLocation"
        private const val ROUTE_MAIN = "main"
        private const val ROUTE_EVENT = "event/{$KEY_EVENT_ID}"
        private const val ROUTE_PEOPLE = "people/{$KEY_COMMUNITY_OR_EVENT_ID}/{$KEY_TYPE_ID}"
        private const val ROUTE_COMMUNITY = "community/{$KEY_COMMUNITY_ID}"
        private const val ROUTE_ENTER_NAME = "enterName"
        private const val ROUTE_ENTER_PHONE = "enterPhone"
        private const val ROUTE_ENTER_PIN = "enterPin"
        private const val ROUTE_CONFIRMED_EVENT = "confirmedEvent"
        private const val ROUTE_PROFILE = "profile"
        private const val ROUTE_EDIT_PROFILE = "editProfile"
        private const val ROUTE_DELETE_PROFILE = "deleteProfile"
    }
}