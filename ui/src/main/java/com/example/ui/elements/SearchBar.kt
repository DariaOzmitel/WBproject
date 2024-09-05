package com.example.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.R
import com.example.ui.elements.text.TextHeading4
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

private const val MAX_LINES_VALUE = 1

@Composable
internal fun SearchBar(
    modifier: Modifier = Modifier,
    searchText: String,
    onProfileClickListener: () -> Unit,
    onValueChange: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var isFocused by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        SearchTextField(
            modifier = Modifier.weight(1f),
            searchText = searchText,
            onValueChange = onValueChange,
            focusManager = focusManager,
            isFocused = isFocused,
            onFocusChange = { isFocused = it })
        when {
            isFocused -> {
                TextHeading4(
                    modifier = Modifier
                        .clickable {
                            onValueChange("")
                            isFocused = false
                            focusManager.clearFocus()
                        }, text = stringResource(id = R.string.cancel)
                )
            }

            else -> {
                Image(
                    modifier = Modifier.clickable { onProfileClickListener() },
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = stringResource(id = R.string.search_hint),
                )
            }
        }
    }
}

@Composable
private fun SearchTextField(
    modifier: Modifier = Modifier,
    searchText: String,
    isFocused: Boolean,
    focusManager: FocusManager,
    onFocusChange: (Boolean) -> Unit,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier
            .padding(end = EventTheme.dimensions.dimension8)
            .background(
                color = EventTheme.colors.neutralOffWhite,
                shape = RoundedCornerShape(EventTheme.dimensions.dimension16)
            )
            .padding(EventTheme.dimensions.dimension10)
            .onFocusChanged {
                onFocusChange(it.isFocused)
                if (!it.isFocused) {
                    focusManager.clearFocus()
                }
            },
        value = searchText,
        onValueChange = onValueChange,
        textStyle = EventTheme.typography.secondary,
        singleLine = true,
        maxLines = MAX_LINES_VALUE,
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        })
    ) { innerTextField ->
        when {
            searchText.isEmpty() && !isFocused -> UnfocusedInnerTextField()
            else -> {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField()
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        modifier = Modifier
                            .clickable { onValueChange("") }
                            .size(EventTheme.dimensions.dimension22),
                        contentDescription = stringResource(id = R.string.search_hint),
                        tint = EventTheme.colors.fontColorGrey
                    )
                }
            }
        }
    }
}

@Composable
private fun UnfocusedInnerTextField(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Filled.Search,
            modifier = Modifier
                .padding(end = EventTheme.dimensions.dimension6)
                .size(EventTheme.dimensions.dimension22),
            contentDescription = stringResource(id = R.string.search_hint),
            tint = EventTheme.colors.fontColorGrey
        )
        TextSecondary(
            text = stringResource(id = R.string.search_hint),
            color = EventTheme.colors.fontColorGrey
        )
    }
}

@Preview
@Composable
private fun SearchFieldPreview() {
    SearchBar(searchText = "", onProfileClickListener = {}) {
    }
}