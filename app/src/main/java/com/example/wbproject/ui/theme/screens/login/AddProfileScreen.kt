package com.example.wbproject.ui.theme.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.domain.IconInCircleArgs
import com.example.wbproject.ui.theme.domain.MyButtonArguments
import com.example.wbproject.ui.theme.elements.MyButton
import com.example.wbproject.ui.theme.elements.MyEditText
import com.example.wbproject.ui.theme.molecules.ProfileAvatar

@Composable
fun AddProfileScreen(onButtonClickListener: () -> Unit) {
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
            iconInCircleArgs = IconInCircleArgs(
                size = MeetingTheme.dimensions.dimension100, painter = painterResource(
                    id = R.drawable.user
                )
            )
        )
        MyEditText(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension12),
            text = stringResource(
                id = R.string.name_necessarily
            )
        )
        MyEditText(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension56),
            text = stringResource(
                id = R.string.last_name_optional
            )
        )
        MyButton(
            args = MyButtonArguments(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MeetingTheme.dimensions.dimension52),
                text = stringResource(id = R.string.save),
                onClick = onButtonClickListener
            )
        )
    }
}