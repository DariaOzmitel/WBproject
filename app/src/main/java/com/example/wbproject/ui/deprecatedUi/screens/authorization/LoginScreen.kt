package com.example.wbproject.ui.theme.deprecatedUi.screens.authorization

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbproject.navigation.LoginScreenTopBarItem
import com.example.wbproject.navigation.NavigationState
import com.example.wbproject.ui.theme.deprecatedUi.molecules.MyTopBar
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigationState: NavigationState,
    content: @Composable () -> Unit
) {
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(modifier = modifier.padding(
        horizontal = MeetingTheme.dimensions.dimension8
    ),
        topBar = {
            val currentItem =
                LoginScreenTopBarItem.items.firstOrNull { it.screen.route == currentRoute }
            MyTopBar(
                title = currentItem?.titleResId?.let {
                    stringResource(id = it)
                },
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
