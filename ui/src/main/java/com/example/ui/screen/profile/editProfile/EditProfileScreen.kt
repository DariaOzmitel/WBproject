package com.example.ui.screen.profile.editProfile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.elements.EventEditText
import com.example.ui.elements.buttons.EventTextButton
import com.example.ui.elements.chips.EventChipsFlowRow16
import com.example.ui.elements.text.TextHeading2
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.model.UserUi.Companion.mockUserUi
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.TextSwitchRow
import com.example.ui.theme.EventTheme

@Composable
fun EditProfileScreen(modifier: Modifier = Modifier) {
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
                Box(modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40)) {
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
                        rightIcon = painterResource(id = R.drawable.check),
                        onRightIconClickListener = {})
                }
            }
            item {
                EventEditText(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    hint = stringResource(id = R.string.name_and_surname),
                    displayText = ""
                ) {
                }
            }
            item {
                EventEditText(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    hint = stringResource(id = R.string.test_phone),
                    displayText = ""
                ) {
                }
            }
            item {
                EventEditText(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    hint = stringResource(id = R.string.city),
                    displayText = ""
                ) {
                }
            }
            item {
                EventEditText(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                    hint = stringResource(id = R.string.description_hint),
                    displayText = ""
                ) {
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension10),
                    text = stringResource(id = R.string.interests)
                )
            }
            item {
                user.interests?.let {
                    EventChipsFlowRow16(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                        chips = it
                    )
                }
            }
            item {
                TextHeading2(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.social_media)
                )
            }
            item {
                EventEditText(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                    hint = stringResource(id = R.string.habr),
                    displayText = ""
                ) {
                }
            }
            item {
                EventEditText(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                    hint = stringResource(id = R.string.telegram),
                    displayText = ""
                ) {
                }
            }
            item {
                TextSwitchRow(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
                    text = stringResource(id = R.string.show_my_communities)
                )
            }
            item {
                TextSwitchRow(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                    text = stringResource(id = R.string.show_my_events)
                )
            }
            item {
                TextSwitchRow(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension40),
                    text = stringResource(id = R.string.enable_notifications)
                )
            }
            item {
                EventTextButton(
                    text = stringResource(id = R.string.delete_profile),
                    color = EventTheme.colors.fontColorRed
                )
            }
        }
    }
}