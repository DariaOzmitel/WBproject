package com.example.wbproject.ui.theme.deprecatedUi.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wbproject.R
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextBody1
import com.example.wbproject.ui.theme.deprecatedUi.theme.LightColors
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

@Composable
fun MySearchTextField(
    modifier: Modifier = Modifier,
    searchText: String,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RectangleShape,
        value = searchText,
        placeholder = {
            TextBody1(
                text = stringResource(id = R.string.search),
                color = MeetingTheme.colors.neutralWeak
            )
        },
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = stringResource(id = R.string.search),
                tint = MeetingTheme.colors.neutralWeak
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = LightColors.brandColorBackGround,
            focusedLeadingIconColor = LightColors.neutralDisabled,
            focusedContainerColor = LightColors.brandColorBackGround,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        )
    )
}