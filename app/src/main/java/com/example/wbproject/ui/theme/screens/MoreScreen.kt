package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.wbproject.navigation.NavigationItem
import com.example.wbproject.navigation.NavigationState
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.MyTextArguments
import com.example.wbproject.ui.theme.elements.MyText

@Composable
fun MoreScreen(navigationState: NavigationState) {
    LazyColumn(modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension100)) {
        val navigationItems = listOf(
            NavigationItem.Profile,
            NavigationItem.MyMeetings,
        )
        items(navigationItems) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MeetingTheme.dimensions.dimension56)
                    .padding(MeetingTheme.dimensions.dimension8)
                    .clickable { navigationState.navigateTo(item.screen.route) },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(MeetingTheme.dimensions.dimension24),
                    painter = painterResource(id = item.iconResId),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(MeetingTheme.dimensions.dimension8))
                Box(modifier = Modifier.weight(1f)) {
                    MyText(
                        myTextArguments = MyTextArguments(
                            text = item.title,
                            textStyle = MeetingTheme.typography.bodyText1
                        )
                    )
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }
}