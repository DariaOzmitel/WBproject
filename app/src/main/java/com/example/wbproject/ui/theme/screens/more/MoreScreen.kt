package com.example.wbproject.ui.theme.screens.more

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
import androidx.compose.ui.res.stringResource
import com.example.wbproject.navigation.NavigationItem
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextBody1

@Composable
fun MoreScreen(onProfileItemClickListener: () -> Unit, onMyMeetingsItemClickListener: () -> Unit) {
    LazyColumn(modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension128)) {
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
                    .clickable {
                        if (item == NavigationItem.Profile)
                            onProfileItemClickListener()
                        if (item == NavigationItem.MyMeetings)
                            onMyMeetingsItemClickListener()
                    },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(MeetingTheme.dimensions.dimension24),
                    painter = painterResource(id = item.iconResId),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(MeetingTheme.dimensions.dimension8))
                Box(modifier = Modifier.weight(1f)) {
                    TextBody1(
                        text = stringResource(id = item.titleResId),
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