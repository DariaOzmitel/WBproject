package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbproject.R
import com.example.wbproject.navigation.MainScreenTopBarItem
import com.example.wbproject.navigation.NavigationState
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.molecules.MyBottomAppBar
import com.example.wbproject.ui.theme.molecules.MyTopBar


@Composable
fun MainScreen(
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
            val currentMainScreenTopBarItem =
                MainScreenTopBarItem.items.firstOrNull { it.screen.route == currentRoute }
            MyTopBar(
                title = stringResource(
                    id = currentMainScreenTopBarItem?.titleResId ?: R.string.meetings
                ),
                canNavigateBack = currentMainScreenTopBarItem?.addLeftArrow ?: false,
                navigateUp = {
                    navigationState.navHostController.navigateUp()
                }
            )
        },
        bottomBar = {
            MyBottomAppBar(
                navBackStackEntry = navBackStackEntry,
                navigationState = navigationState
            )
        }
    ) {
        content()
    }
}

