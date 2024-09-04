package com.example.ui.navigation

import androidx.compose.runtime.Composable
import com.example.ui.screen.onboarding.selectLocation.SelectLocationScreen
import com.example.ui.screen.onboarding.select_interest.SelectInterestScreen
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
            }
        },
    )
}