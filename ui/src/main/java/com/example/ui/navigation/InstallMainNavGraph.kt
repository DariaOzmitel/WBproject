package com.example.ui.navigation

import androidx.compose.runtime.Composable
import com.example.ui.screen.appointment.ConfirmedEventScreen
import com.example.ui.screen.appointment.EnterNameScreen
import com.example.ui.screen.appointment.EnterPhoneScreen
import com.example.ui.screen.appointment.EnterPinScreen
import com.example.ui.screen.main.community.CommunityScreen
import com.example.ui.screen.main.event.EventScreen
import com.example.ui.screen.main.mainPage.MainPageScreen
import com.example.ui.screen.main.people.PeopleScreen
import com.example.ui.screen.onboarding.selectLocation.SelectLocationScreen
import com.example.ui.screen.onboarding.select_interest.SelectInterestScreen
import com.example.ui.screen.profile.ProfileScreen
import com.example.ui.screen.profile.deleteProfile.DeleteProfileScreen
import com.example.ui.screen.profile.editProfile.EditProfileScreen
import com.example.ui.screen.splash.SplashScreen

@Composable
fun InstallMainNavGraph() {
    val navigationState = rememberNavigationState()
    MainNavGraph(
        navHostController = navigationState.navHostController,
        splashScreenContent = {
            SplashScreen {
                navigationState.navigateTo(Screen.SelectInterest.route)
            }
        },
        selectInterestScreenContent = {
            SelectInterestScreen(onClickListener = {
                navigationState.navigateTo(
                    Screen.SelectLocation.route
                )
            })
        },
        selectLocationScreenContent = {
            SelectLocationScreen {
                navigationState.navigateTo(Screen.Main.route)
            }
        },
        mainScreenContent = {
            MainPageScreen(
                onMainEventCardClickListener = { eventId ->
                    navigationState.navigateToEvent(eventId)
                },
                onEventCardClickListener = { eventId ->
                    navigationState.navigateToEvent(eventId)
                },
                onProfileClickListener = { navigationState.navigateTo(Screen.Profile.route) },
                onEventCardMaxWidthClickListener = { eventId ->
                    navigationState.navigateToEvent(
                        eventId
                    )
                },
                onCommunityCardClickListener = { communityId ->
                    navigationState.navigateToCommunity(communityId)
                })
        },
        eventScreenContent = {
            EventScreen(onEventCardClickListener = { eventId ->
                navigationState.navigateToEvent(eventId)
            }, onLeftIconClickListener = { navigationState.navHostController.navigateUp() },
                onOrganizerCardClickListener = { communityId ->
                    navigationState.navigateToCommunity(
                        communityId
                    )
                },
                onButtonClickListener = { navigationState.navigateTo(Screen.EnterName.route) },
                onAvatarsRowClickListener = { navigationState.navigateTo(Screen.People.route) })
        },
        peopleScreenContent = {
            PeopleScreen(
                onUserCardClickListener = { navigationState.navigateTo(Screen.Profile.route) },
                onLeftIconClickListener = { navigationState.navHostController.navigateUp() })
        },
        communityScreenContent = {
            CommunityScreen(
                onLeftIconClickListener = { navigationState.navHostController.navigateUp() },
                onEventCardClickListener = { eventId ->
                    navigationState.navigateToEvent(eventId)
                },
                onEventCardMaxWidthClickListener = { eventId ->
                    navigationState.navigateToEvent(
                        eventId
                    )
                },
                onAvatarsRowClickListener = { navigationState.navigateTo(Screen.People.route) })
        },
        enterNameScreenContent = {
            EnterNameScreen {
                navigationState.navigateTo(Screen.EnterPhone.route)
            }
        },
        enterPhoneScreenContent = {
            EnterPhoneScreen {
                navigationState.navigateTo(Screen.EnterPin.route)
            }
        },
        enterPinScreenContent = {
            EnterPinScreen {
                navigationState.navigateTo(Screen.ConfirmedEvent.route)
            }
        },
        confirmedEventScreenContent = {
            ConfirmedEventScreen(onMyEventsButtonClickListener = {
                navigationState.navigateTo(Screen.Profile.route)
            }) {
                navigationState.navigateTo(Screen.Main.route)
            }
        },
        profileScreenContent = {
            ProfileScreen(
                onLeftIconClickListener = { navigationState.navHostController.navigateUp() },
                onCommunityCardClickListener = { communityId ->
                    navigationState.navigateToCommunity(communityId)
                },
                onEventCardClickListener = { eventId ->
                    navigationState.navigateToEvent(eventId)
                })
        },
        editProfileScreenContent = { EditProfileScreen() },
        deleteProfileScreenContent = { DeleteProfileScreen() }
    )
}