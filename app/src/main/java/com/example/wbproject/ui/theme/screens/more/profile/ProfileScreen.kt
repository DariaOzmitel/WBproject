package com.example.wbproject.ui.theme.screens.more.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.IconInCircle
import com.example.wbproject.ui.theme.elements.ProgressIndicator
import com.example.wbproject.ui.theme.elements.buttons.MyOutlinedButton
import com.example.wbproject.ui.theme.elements.text.TextHeading1
import com.example.wbproject.ui.theme.elements.text.TextSubheading2
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val viewModel: ProfileViewModel = koinViewModel()
    val profileState by viewModel.getProfileStateFlow().collectAsStateWithLifecycle()

    when (val state = profileState) {
        is ProfileState.Loading -> ProgressIndicator()
        is ProfileState.Profile -> ProfileContent(modifier = modifier, user = state.user)
    }
}

@Composable
private fun ProfileContent(modifier: Modifier = Modifier, user: User) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension136,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (user.avatarUrl.isEmpty()) {
            true ->
                IconInCircle(
                    size = MeetingTheme.dimensions.dimension200, painter = painterResource(
                        id = R.drawable.user
                    )
                )

            false ->
                AsyncImage(
                    modifier = Modifier
                        .size(MeetingTheme.dimensions.dimension200)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    model = user.avatarUrl,
                    contentDescription = null,
                )
        }

        TextHeading1(
            modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension16),
            text = String.format(
                stringResource(id = R.string.name_surname_template),
                user.name,
                user.lastName
            ),
        )
        TextSubheading2(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension40),
            text = user.phone,
            color = MeetingTheme.colors.neutralDisabled
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonSocialNetwork(iconResId = R.drawable.twitter)
            ButtonSocialNetwork(iconResId = R.drawable.instagram)
            ButtonSocialNetwork(iconResId = R.drawable.linked_in)
            ButtonSocialNetwork(iconResId = R.drawable.facebook)
        }
    }
}

@Composable
private fun ButtonSocialNetwork(iconResId: Int) {
    MyOutlinedButton(
        contentPadding =
        PaddingValues(
            horizontal = MeetingTheme.dimensions.dimension26,
            vertical = MeetingTheme.dimensions.dimension10
        ),
        contentModifier = Modifier.size(MeetingTheme.dimensions.dimension20),
        iconResId = iconResId
    )
}

@Preview
@Composable
private fun ProfileContentPreview() {
    ProfileContent(user = mockUser)
}