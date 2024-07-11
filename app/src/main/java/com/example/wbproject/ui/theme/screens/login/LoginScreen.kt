package com.example.wbproject.ui.theme.screens.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbproject.navigation.LoginScreenTopBarItem
import com.example.wbproject.navigation.NavigationState
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.molecules.MyTopBar

@Composable
fun LoginScreen(navigationState: NavigationState, content: @Composable () -> Unit) {
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(modifier = Modifier.padding(
        start = MeetingTheme.dimensions.dimension8,
        end = MeetingTheme.dimensions.dimension8
    ),
        topBar = {
            val currentItem =
                LoginScreenTopBarItem.items.firstOrNull { it.screen.route == currentRoute }
            MyTopBar(
                title = if (currentItem?.titleResId != null) {
                    stringResource(
                        id = currentItem.titleResId
                    )
                } else "",
                canNavigateBack = currentItem?.addLeftArrow ?: false,
                navigateUp = {
                    navigationState.navHostController.navigateUp()
                }
            )
        }
    ) {
        content()
    }
}
