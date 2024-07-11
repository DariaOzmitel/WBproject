package com.example.wbproject.ui.theme.screens.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.domain.IconInCircleArgs
import com.example.wbproject.ui.theme.domain.MoreMenuItem
import com.example.wbproject.ui.theme.elements.IconInCircle
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.elements.text.TextMetadata1


@Composable
fun MoreScreen(onProfileItemClickListener: () -> Unit, onMyMeetingsItemClickListener: () -> Unit) {
    Column(modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension100)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(MeetingTheme.dimensions.dimension66)
                .padding(MeetingTheme.dimensions.dimension8)
                .clickable { onProfileItemClickListener() },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconInCircle(
                iconInCircleArgs = IconInCircleArgs(
                    size = MeetingTheme.dimensions.dimension50,
                    painter = painterResource(id = R.drawable.user)
                )
            )
            Spacer(modifier = Modifier.width(MeetingTheme.dimensions.dimension12))
            Box(modifier = Modifier.weight(1f)) {
                Column {
                    TextBody1(
                        text = stringResource(id = R.string.test_profile_name),
                    )
                    TextMetadata1(
                        modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension4),
                        text = stringResource(id = R.string.test_profile_phone),
                        color = MeetingTheme.colors.neutralDisabled
                    )
                }

            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
        MenuItem(
            moreMenuItem = MoreMenuItem.MyMeetings,
            onItemClickListener = onMyMeetingsItemClickListener
        )
        Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension4))
        MenuItem(
            moreMenuItem = MoreMenuItem.Theme
        )
        MenuItem(
            moreMenuItem = MoreMenuItem.Notifications
        )
        MenuItem(
            moreMenuItem = MoreMenuItem.Safety
        )
        MenuItem(
            moreMenuItem = MoreMenuItem.MemoryAndResources
        )
        Divider()
        MenuItem(
            moreMenuItem = MoreMenuItem.Help
        )
        MenuItem(
            moreMenuItem = MoreMenuItem.InviteFriend
        )
    }
}

@Composable
private fun MenuItem(
    modifier: Modifier = Modifier,
    moreMenuItem: MoreMenuItem,
    onItemClickListener: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(MeetingTheme.dimensions.dimension48)
            .padding(MeetingTheme.dimensions.dimension8)
            .clickable { onItemClickListener() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.size(MeetingTheme.dimensions.dimension24),
            painter = painterResource(id = moreMenuItem.iconResId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(MeetingTheme.dimensions.dimension8))
        Box(modifier = Modifier.weight(1f)) {
            TextBody1(
                text = stringResource(id = moreMenuItem.titleResId),
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun MoreScreenPreview() {
    MoreScreen(onProfileItemClickListener = {}) {

    }
}