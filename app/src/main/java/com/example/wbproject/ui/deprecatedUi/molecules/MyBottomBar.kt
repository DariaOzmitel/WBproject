package com.example.wbproject.ui.theme.deprecatedUi.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.wbproject.R
import com.example.wbproject.navigation.BottomNavigationItem
import com.example.wbproject.navigation.NavigationState
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextBody1
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

@Composable
fun MyBottomAppBar(
    modifier: Modifier = Modifier,
    navBackStackEntry: NavBackStackEntry?,
    navigationState: NavigationState
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = Color.Transparent
    ) {
        BottomNavigationItem.bottomNavigationItems.forEach { item ->
            val isSelected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navigationState.navigateTo(item.screen.route)
                    }
                },
                icon = {
                    when (isSelected) {
                        false -> Icon(
                            painter = painterResource(id = item.iconResId),
                            contentDescription = null
                        )

                        true -> Column(
                            verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension8),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TextBody1(
                                text = stringResource(id = item.titleResId)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.point),
                                contentDescription = null
                            )
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}
