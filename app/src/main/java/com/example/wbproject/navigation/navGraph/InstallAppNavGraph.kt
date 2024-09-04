package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import com.example.wbproject.navigation.ScreenV1
import com.example.wbproject.navigation.rememberNavigationState
import com.example.wbproject.ui.deprecatedUi.screens.authorization.enter_phone.EnterPhoneScreen
import com.example.wbproject.ui.deprecatedUi.screens.meetings.MeetingListScreen
import com.example.wbproject.ui.deprecatedUi.screens.more.MoreScreen
import com.example.wbproject.ui.deprecatedUi.screens.more.my_meetings.MyMeetingScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.MainScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.LoginScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.add_profile.AddProfileScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.enter_pin.EnterPinScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.community.CommunityListScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.community.community_detail.CommunityDetailScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.meetings.meeting_detail.MeetingDetailScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.more.profile.ProfileScreen
import com.example.wbproject.ui.theme.deprecatedUi.screens.splash.DeprecatedSplashScreen

@Composable
fun InstallAppNavGraph() {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        meetingListScreenContent = {
            MainScreen(navigationState = navigationState) {
                MeetingListScreen(
                    onMeetingCardClickListener = { navigationState.navigateToMeetingDetail(it) }
                )
            }
        },
        communityListScreenContent = {
            MainScreen(navigationState = navigationState) {
                CommunityListScreen(
                    onCommunityCardClickListener =
                    {
                        navigationState.navigateToCommunityDetail(it)
                    }
                )
            }
        },
        moreMenuScreenContent = {
            MainScreen(navigationState = navigationState) {
                MoreScreen(
                    onProfileItemClickListener = {
                        navigationState.navigateTo(ScreenV1.Profile.route)
                    },
                    onMyMeetingsItemClickListener = {
                        navigationState.navigateTo(ScreenV1.MyMeetings.route)
                    }
                )
            }
        },
        myMeetingScreenContent = {
            MainScreen(navigationState = navigationState) {
                MyMeetingScreen(
                    onMeetingCardClickListener = {
                        navigationState.navigateToMeetingDetail(it)
                    }
                )
            }
        },
        profileScreenContent = {
            MainScreen(navigationState = navigationState) {
                ProfileScreen()
            }
        },
        communityDetailScreenContent = {
            MainScreen(navigationState = navigationState) {
                CommunityDetailScreen(
                    onMeetingCardClickListener = {
                        navigationState.navigateToMeetingDetail(it)
                    })
            }
        },
        meetingDetailScreenContent = {
            MainScreen(navigationState = navigationState) {
                MeetingDetailScreen()
            }
        },
        enterPhoneScreenContent = {
            LoginScreen(navigationState = navigationState) {
                EnterPhoneScreen(onButtonClickListener = {
                    navigationState.navigateToEnterPin(it)
                })
            }
        },
        enterPinScreenContent = {
            LoginScreen(navigationState = navigationState) {
                EnterPinScreen(correctPinEnteredListener = { navigationState.navigateToAddProfile(it) })
            }

        },
        addProfileScreenContent = {
            LoginScreen(navigationState = navigationState) {
                AddProfileScreen(onButtonClickListener = {
                    navigationState.navigateTo(ScreenV1.MeetingsList.route)
                })
            }
        },
        splashScreenContent = {
            DeprecatedSplashScreen(
                animationEndListener = { status ->
                    when (status) {
                        true -> navigationState.navigateTo(ScreenV1.MeetingsList.route)
                        false -> navigationState.navigateTo(ScreenV1.EnterPhone.route)
                    }

                }
//                animationEndListener = { navigationState.navigateTo(Screen.EnterPhone.route) }
            )
        })
}
