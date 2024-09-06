package com.example.wbproject.ui.deprecatedUi.screens.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.data.mockData.mockUser
import com.example.domain.model.User
import com.example.wbproject.R
import com.example.wbproject.ui.deprecatedUi.items.MoreMenuItem
import com.example.wbproject.ui.theme.deprecatedUi.elements.IconInCircle
import com.example.wbproject.ui.theme.deprecatedUi.elements.ProgressIndicator
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextBody1
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextMetadata1
import com.example.wbproject.ui.theme.deprecatedUi.screens.more.MoreState
import com.example.wbproject.ui.theme.deprecatedUi.screens.more.MoreViewModel
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MoreScreen(
    modifier: Modifier = Modifier,
    onProfileItemClickListener: () -> Unit,
    onMyMeetingsItemClickListener: () -> Unit
) {
    val viewModel: MoreViewModel = koinViewModel()
    val moreState by viewModel.getMoreStateFlow().collectAsStateWithLifecycle()
    Column(modifier = modifier.padding(top = MeetingTheme.dimensions.dimension106)) {
        when (val state = moreState) {
            is MoreState.Loading -> ProgressIndicator(modifier = Modifier.size(MeetingTheme.dimensions.dimension40))
            is MoreState.MoreUser -> UserContent(user = state.user, onProfileItemClickListener)
        }
        MenuItem(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension4),
            moreMenuItem = MoreMenuItem.MyMeetings,
            onItemClickListener = onMyMeetingsItemClickListener
        )
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
        HorizontalDivider()
        MenuItem(
            moreMenuItem = MoreMenuItem.Help
        )
        MenuItem(
            moreMenuItem = MoreMenuItem.InviteFriend
        )
    }
}

@Composable
private fun UserContent(user: User, onProfileItemClickListener: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(MeetingTheme.dimensions.dimension66)
            .padding(MeetingTheme.dimensions.dimension8)
            .clickable { onProfileItemClickListener() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        when (user.avatarModel == null) {
            true ->
                IconInCircle(
                    size = MeetingTheme.dimensions.dimension50,
                    painter = painterResource(id = R.drawable.user)
                )

            false ->
                AsyncImage(
                    modifier = Modifier
                        .size(MeetingTheme.dimensions.dimension50)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    model = user.avatarModel,
                    contentDescription = null,
                )
        }
        Column(
            modifier = Modifier
                .padding(start = MeetingTheme.dimensions.dimension12)
                .weight(1f)
        ) {
            TextBody1(
                text = String.format(
                    stringResource(id = R.string.name_surname_template),
                    user.name,
                    user.lastName
                ),
            )
            TextMetadata1(
                modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension4),
                text = user.phone,
                color = MeetingTheme.colors.neutralDisabled
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
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
        modifier = modifier
            .fillMaxWidth()
            .height(MeetingTheme.dimensions.dimension48)
            .padding(MeetingTheme.dimensions.dimension8)
            .clickable { onItemClickListener() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(end = MeetingTheme.dimensions.dimension8)
                .size(MeetingTheme.dimensions.dimension24),
            painter = painterResource(id = moreMenuItem.iconResId),
            contentDescription = null
        )
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
    UserContent(user = mockUser) {}
}