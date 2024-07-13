package com.example.wbproject.ui.theme.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MyEditText
import com.example.wbproject.ui.theme.elements.buttons.MyButton
import com.example.wbproject.ui.theme.molecules.ProfileAvatar

@Composable
fun AddProfileScreen(onButtonClickListener: () -> Unit) {
    var nameText by remember { mutableStateOf("") }
    var lastNameText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = MeetingTheme.dimensions.dimension200,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileAvatar(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension32),
            size = MeetingTheme.dimensions.dimension100, painter = painterResource(
                id = R.drawable.user
            )
        )
        MyEditText(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension12),
            hint = stringResource(
                id = R.string.name_necessarily
            ), displayText = nameText, onValueChange = { nameText = it }
        )
        MyEditText(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension56),
            hint = stringResource(
                id = R.string.last_name_optional
            ), displayText = lastNameText, onValueChange = { lastNameText = it }
        )
        MyButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(MeetingTheme.dimensions.dimension52),
            text = stringResource(id = R.string.save),
            onClick = onButtonClickListener,
            enabled = nameText.isNotEmpty()
        )
    }
}