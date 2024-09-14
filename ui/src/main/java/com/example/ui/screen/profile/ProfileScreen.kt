package com.example.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.elements.buttons.EventTextButton
import com.example.ui.elements.chips.EventChipsFlowRow14
import com.example.ui.elements.text.TextHeading2
import com.example.ui.elements.text.TextHeading4
import com.example.ui.elements.text.TextHeadingHuge
import com.example.ui.elements.text.TextSecondary
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.model.UserUi.Companion.mockUserUi
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.communityCard.MyCommunityCardRow
import com.example.ui.molecules.eventCard.EventCardRow
import com.example.ui.theme.EventTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val user = mockUserUi
    Scaffold { innerPadding ->
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
                    CustomTopBar(onLeftIconClickListener = {},
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
                user.events?.let {
                    EventCardRow(
                        modifier = Modifier
                            .ignoreHorizontalParentPadding()
                            .padding(bottom = EventTheme.dimensions.dimension40),
                        meetings = it
                    )
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.my_communities)
                )
            }
            item {
                user.communities?.let {
                    MyCommunityCardRow(
                        modifier = Modifier
                            .ignoreHorizontalParentPadding()
                            .padding(bottom = EventTheme.dimensions.dimension40),
                        communities = it
                    )
                }
            }
            item {
                EventTextButton(
                    text = stringResource(id = R.string.exit),
                    color = EventTheme.colors.fontColorGrey
                )
            }
        }
    }
}