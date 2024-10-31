package com.example.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.buttons.EventTextButton
import com.example.ui.elements.chips.EventChipsFlowRow14
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextHeading4
import com.example.ui.elements.text.TextHeadingHuge
import com.example.ui.elements.text.TextSecondary
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.model.UserUi
import com.example.ui.model.UserUi.Companion.mockUserUi
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.communityCard.MyCommunityCardRow
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.theme.EventTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ProfileScreen(
    modifier: Modifier = Modifier,
    onLeftIconClickListener: () -> Unit,
    onCommunityCardClickListener: (Int) -> Unit,
    onExitButtonClickListener: () -> Unit,
    onEventCardClickListener: (Int) -> Unit
) {
    val viewModel: ProfileViewModel = koinViewModel()
    val profileState by viewModel.getProfileStateFlow().collectAsStateWithLifecycle()
    when (val state = profileState) {
        is ProfileState.Loading -> ProgressIndicator()
        is ProfileState.ProfileContent -> {
            Scaffold { innerPadding ->
                ProfileScreenContent(
                    modifier = modifier,
                    innerPadding = innerPadding,
                    user = state.user,
                    onLeftIconClickListener = onLeftIconClickListener,
                    onCommunityCardClickListener = onCommunityCardClickListener,
                    onExitButtonClickListener = onExitButtonClickListener
                ) {
                    onEventCardClickListener(it)
                }
            }
        }
    }

}

@Composable
private fun ProfileScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    user: UserUi,
    onLeftIconClickListener: () -> Unit,
    onCommunityCardClickListener: (Int) -> Unit,
    onExitButtonClickListener: () -> Unit,
    onEventCardClickListener: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(
                top = innerPadding.calculateTopPadding(),
                start = EventTheme.dimensions.dimension16,
                bottom = EventTheme.dimensions.dimension24,
                end = EventTheme.dimensions.dimension16
            )
    ) {
        item {
            Box(modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension20)) {
                AsyncImage(
                    modifier = Modifier
                        .ignoreHorizontalParentPadding()
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    model = user.avatarModel,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                CustomTopBar(onLeftIconClickListener = onLeftIconClickListener,
                    rightIcon = painterResource(id = R.drawable.share),
                    onRightIconClickListener = {})
            }
        }
        item {
            TextHeadingHuge(text = user.name)
        }
        item {
            user.city?.let {
                TextHeading4(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension2),
                    text = it
                )
            }
        }
        item {
            user.description?.let {
                TextSecondary(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = it
                )
            }
        }
        item {
            user.interests?.let {
                EventChipsFlowRow14(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    chips = it
                )
            }
        }
        item {
            Row(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                horizontalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8)
            ) {
                Image(
                    modifier = Modifier.size(EventTheme.dimensions.dimension52),
                    painter = painterResource(id = R.drawable.habr),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(EventTheme.dimensions.dimension52),
                    painter = painterResource(id = R.drawable.telegram),
                    contentDescription = ""
                )
            }
        }
        item {
            TextHeading2(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension10),
                text = stringResource(id = R.string.my_event)
            )
        }
        item {
            user.events?.let { events ->
                EventCardRow(
                    modifier = Modifier
                        .ignoreHorizontalParentPadding()
                        .padding(bottom = EventTheme.dimensions.dimension40),
                    events = events
                ) {
                    onEventCardClickListener(it)
                }
            }
        }
        item {
            TextHeading2(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                text = stringResource(id = R.string.my_communities)
            )
        }
        item {
            user.communities?.let { communities ->
                MyCommunityCardRow(
                    modifier = Modifier
                        .ignoreHorizontalParentPadding()
                        .padding(bottom = EventTheme.dimensions.dimension40),
                    communities = communities
                ) {
                    onCommunityCardClickListener(it)
                }
            }
        }
        item {
            EventTextButton(
                text = stringResource(id = R.string.exit),
                color = EventTheme.colors.fontColorGrey,
                onClick = onExitButtonClickListener
            )
        }
    }
}

@Preview
@Composable
private fun ProfileScreenContentPreview() {
    ProfileScreenContent(
        innerPadding = PaddingValues(0.dp),
        user = mockUserUi,
        onLeftIconClickListener = {},
        onExitButtonClickListener = {},
        onCommunityCardClickListener = {}) {
    }
}