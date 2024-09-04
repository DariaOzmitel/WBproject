package com.example.wbproject.navigation

sealed class ScreenV1(
    val route: String
) {
    object Splash : ScreenV1(ROUTE_SPLASH)
    object EnterPhone : ScreenV1(ROUTE_ENTER_PHONE)
    object EnterPin : ScreenV1(ROUTE_ENTER_PIN) {

        private const val ROUTE_FOR_ARGS = "enter_pin"

        fun getRouteWithArgs(phone: String): String {
            return "$ROUTE_FOR_ARGS/$phone"
        }
    }

    object AddProfile : ScreenV1(ROUTE_ADD_PROFILE) {

        private const val ROUTE_FOR_ARGS = "add_profile"

        fun getRouteWithArgs(phone: String): String {
            return "$ROUTE_FOR_ARGS/$phone"
        }
    }

    object MeetingsRoot : ScreenV1(ROUTE_MEETINGS_ROOT)
    object MeetingsList : ScreenV1(ROUTE_MEETINGS_LIST)
    object MeetingDetail : ScreenV1(ROUTE_MEETING_DETAIL) {

        private const val ROUTE_FOR_ARGS = "meeting_detail"

        fun getRouteWithArgs(meetingId: Int): String {
            return "$ROUTE_FOR_ARGS/$meetingId"
        }
    }

    object CommunityList : ScreenV1(ROUTE_COMMUNITY_LIST)
    object CommunityRoot : ScreenV1(ROUTE_COMMUNITY_ROOT)
    object CommunityDetail : ScreenV1(ROUTE_COMMUNITY_DETAIL) {

        private const val ROUTE_FOR_ARGS = "community_detail"

        fun getRouteWithArgs(communityId: Int): String {
            return "$ROUTE_FOR_ARGS/$communityId"
        }
    }

    object MoreRoot : ScreenV1(ROUTE_MORE_ROOT)
    object MoreMenu : ScreenV1(ROUTE_MORE_MENU)
    object Profile : ScreenV1(ROUTE_PROFILE)
    object MyMeetings : ScreenV1(ROUTE_MY_MEETINGS)

    companion object {
        const val KEY_COMMUNITY_ID = "community_id"
        const val KEY_MEETING_ID = "meeting_id"
        const val KEY_PHONE = "phone"

        private const val ROUTE_MEETINGS_ROOT = "meetings_root"
        private const val ROUTE_SPLASH = "splash"
        private const val ROUTE_ENTER_PHONE = "enter_phone"
        private const val ROUTE_ENTER_PIN = "enter_pin/{$KEY_PHONE}"
        private const val ROUTE_ADD_PROFILE = "add_profile/{$KEY_PHONE}"
        private const val ROUTE_MEETING_DETAIL = "meeting_detail/{$KEY_MEETING_ID}"
        private const val ROUTE_MEETINGS_LIST = "meetings_list"
        private const val ROUTE_MY_MEETINGS = "my_meetings"
        private const val ROUTE_COMMUNITY_LIST = "community_list"
        private const val ROUTE_COMMUNITY_ROOT = "community_root"
        private const val ROUTE_COMMUNITY_DETAIL = "community_detail/{$KEY_COMMUNITY_ID}"
        private const val ROUTE_MORE_ROOT = "more_root"
        private const val ROUTE_MORE_MENU = "more_menu"
        private const val ROUTE_PROFILE = "profile"
    }
}