package com.example.ui.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.elements.EventEditText
import com.example.ui.elements.EventSwitch
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.buttons.SubscribeButton
import com.example.ui.elements.chips.EventChip14
import com.example.ui.elements.chips.EventChip16
import com.example.ui.elements.chips.EventChip22
import com.example.ui.elements.images.CommunityAvatar
import com.example.ui.elements.images.EventAvatar
import com.example.ui.theme.EventTheme

@Composable
fun UiElementsScreen() {
    var isPressed by rememberSaveable {
        mutableStateOf(false)
    }
    var displayText by rememberSaveable {
        mutableStateOf("")
    }
    var isChecked by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .background(EventTheme.colors.neutralDisabled)
            .padding(
                top = EventTheme.dimensions.dimension128,
                start = EventTheme.dimensions.dimension8,
                end = EventTheme.dimensions.dimension8,
            ),
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8)
    ) {
        item {
            EventEditText(
                hint = stringResource(id = R.string.name_and_surname),
                displayText = displayText
            ) {
                displayText = it
            }
        }
        item {
            EventEditText(
                hint = stringResource(id = R.string.name_and_surname),
                displayText = displayText,
                isError = true
            ) {
                displayText = it
            }
        }
        item {
            EventChip14(text = stringResource(id = R.string.testing))
        }
        item {
            EventChip16(text = stringResource(id = R.string.testing), isPressed = isPressed) {
                isPressed = !isPressed
            }
        }
        item {
            EventChip22(text = stringResource(id = R.string.design), isPressed = isPressed) {
                isPressed = !isPressed
            }
        }
        item {
            EventButton(text = stringResource(id = R.string.pay), isLoading = isPressed) {
                isPressed = !isPressed
            }
        }
        item {
            EventButton(text = stringResource(id = R.string.pay), enabled = false)
        }
        item {
            EventButton(text = stringResource(id = R.string.pay), secondaryStatus = true)
        }
        item {
            SubscribeButton(subscribeStatus = isPressed) {
                isPressed = !isPressed
            }
        }
        item {
            EventSwitch(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
            )
        }
        item {
            CommunityAvatar(model = R.drawable.community_avatar_example)
        }
        item {
            EventAvatar(model = "https://thumb.tildacdn.com/tild6465-6132-4937-b964-336163313261/-/resize/560x/-/format/webp/mem-2-1024x683.jpg")
        }
    }
}