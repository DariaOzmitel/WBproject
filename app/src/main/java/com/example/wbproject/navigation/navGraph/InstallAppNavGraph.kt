package com.example.wbproject.navigation.navGraph

import androidx.compose.runtime.Composable
import com.example.wbproject.navigation.Screen
import com.example.wbproject.navigation.rememberNavigationState
import com.example.wbproject.ui.theme.screens.MainScreen
import com.example.wbproject.ui.theme.screens.authorization.LoginScreen
import com.example.wbproject.ui.theme.screens.authorization.add_profile.AddProfileScreen
import com.example.wbproject.ui.theme.screens.authorization.enter_phone.EnterPhoneScreen
import com.example.wbproject.ui.theme.screens.authorization.enter_pin.EnterPinScreen
import com.example.wbproject.ui.theme.screens.community.CommunityListScreen
import com.example.wbproject.ui.theme.screens.community.community_detail.CommunityDetailScreen
import com.example.wbproject.ui.theme.screens.meetings.MeetingListScreen
import com.example.wbproject.ui.theme.screens.meetings.meeting_detail.MeetingDetailScreen
import com.example.wbproject.ui.theme.screens.more.MoreScreen
import com.example.wbproject.ui.theme.screens.more.my_meetings.MyMeetingScreen
import com.example.wbproject.ui.theme.screens.more.profile.ProfileScreen
import com.example.wbproject.ui.theme.screens.splash.SplashScreen

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
                        navigationState.navigateTo(Screen.Profile.route)
                    },
                    onMyMeetingsItemClickListener = {
                        navigationState.navigateTo(Screen.MyMeetings.route)
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
                    navigationState.navigateTo(Screen.EnterPin.route)
                })
            }
        },
        enterPinScreenContent = {
            LoginScreen(navigationState = navigationState) {
                EnterPinScreen(correctPinEnteredListener = { navigationState.navigateTo(Screen.AddProfile.route) })
            }

        },
        addProfileScreenContent = {
            LoginScreen(navigationState = navigationState) {
                AddProfileScreen(onButtonClickListener = {
                    navigationState.navigateTo(Screen.MeetingsList.route)
                })
            }
        },
        splashScreenContent = {
            SplashScreen(
                animationEndListener = { status ->
                    when (status) {
                        true -> navigationState.navigateTo(Screen.MeetingsList.route)
                        false -> navigationState.navigateTo(Screen.EnterPhone.route)
                    }

                }
//                animationEndListener = { navigationState.navigateTo(Screen.EnterPhone.route) }
            )
        })
}
