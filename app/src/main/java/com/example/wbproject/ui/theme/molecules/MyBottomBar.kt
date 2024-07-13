package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.wbproject.R
import com.example.wbproject.navigation.BottomNavigationItem
import com.example.wbproject.navigation.NavigationState
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.MyTextArguments
import com.example.wbproject.ui.theme.elements.MyText


private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        0.0f,
        0.0f,
        0.0f,
        0.0f
    )
}

@Composable
fun MyBottomAppBar(navBackStackEntry: NavBackStackEntry?, navigationState: NavigationState) {
    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        BottomNavigationItem.bottomNavigationItems.forEach { item ->
            val isSelected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false
            CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        if (!isSelected) {
                            navigationState.navigateTo(item.screen.route)
                        }
                    },
                    icon = {
                        if (!isSelected) {
                            Icon(
                                painter = painterResource(id = item.iconResId),
                                contentDescription = null
                            )
                        } else {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension8),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                MyText(
                                    myTextArguments = MyTextArguments(
                                        text = stringResource(id = item.titleResId),
                                        textStyle = MeetingTheme.typography.bodyText1
                                    )
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
}
