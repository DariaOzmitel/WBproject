package com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.add_profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.wbproject.R
import com.example.wbproject.ui.theme.deprecatedUi.elements.MyAsyncAvatar
import com.example.wbproject.ui.theme.deprecatedUi.elements.MyEditText
import com.example.wbproject.ui.theme.deprecatedUi.elements.buttons.MyButton
import com.example.wbproject.ui.theme.deprecatedUi.molecules.ProfileAvatar
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme
import org.koin.androidx.compose.koinViewModel

private const val LAUNCH_INPUT = "image/*"

@Composable
fun AddProfileScreen(modifier: Modifier = Modifier, onButtonClickListener: () -> Unit) {
    val viewModel: AddProfileViewModel = koinViewModel()
    val user by viewModel.getUserFlow().collectAsStateWithLifecycle()
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) {
            it?.let {
                viewModel.updateAvatar(it.toString())
            }
        }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = MeetingTheme.dimensions.dimension136,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = MeetingTheme.dimensions.dimension32)
                .height(MeetingTheme.dimensions.dimension136)
                .clickable {
                    launcher.launch(LAUNCH_INPUT)
                },
            contentAlignment = Alignment.Center
        ) {
            when (user.avatarUrl.isNullOrEmpty()) {
                true -> ProfileAvatar(
                    size = MeetingTheme.dimensions.dimension100, painter = painterResource(
                        id = R.drawable.user
                    )
                )

                false -> MyAsyncAvatar(
                    model = user.avatarUrl.orEmpty(),
                    modifier = Modifier
                        .size(MeetingTheme.dimensions.dimension128),
                )
            }
        }


        MyEditText(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension12),
            hint = stringResource(
                id = R.string.name_necessarily
            ), displayText = user.name, onValueChange = { viewModel.updateName(it) }
        )
        MyEditText(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension56),
            hint = stringResource(
                id = R.string.last_name_optional
            ),
            displayText = user.lastName.orEmpty(),
            onValueChange = { viewModel.updateLastName(it) }
        )
        MyButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.save),
            onClick = {
                viewModel.addUser()
                onButtonClickListener()
            },
            enabled = user.name.isNotEmpty()
        )
    }
}