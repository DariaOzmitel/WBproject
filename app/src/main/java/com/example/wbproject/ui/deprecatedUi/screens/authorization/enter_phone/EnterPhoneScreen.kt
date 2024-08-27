package com.example.wbproject.ui.deprecatedUi.screens.authorization.enter_phone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.mockData.mockUser
import com.example.wbproject.R
import com.example.wbproject.ui.deprecatedUi.items.DropdownMenuItems
import com.example.wbproject.ui.theme.deprecatedUi.elements.CustomPhoneNumber
import com.example.wbproject.ui.theme.deprecatedUi.elements.ProgressIndicator
import com.example.wbproject.ui.theme.deprecatedUi.elements.buttons.MyButton
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextBody2
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextHeading2Old
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme
import org.koin.androidx.compose.koinViewModel

private const val PHONE_LENGTH = 10

@Composable
fun EnterPhoneScreen(modifier: Modifier = Modifier, onButtonClickListener: (String) -> Unit) {
    val viewModel: EnterPhoneViewModel = koinViewModel()
    val state by viewModel.getEnterPhoneStateFlow().collectAsStateWithLifecycle()
    when (val enterPhoneState = state) {
        is EnterPhoneState.Loading -> ProgressIndicator()
        is EnterPhoneState.EnterPhoneContent -> {
            EnterPhoneScreenContent(
                modifier = modifier,
                phone = enterPhoneState.phone,
                expanded = enterPhoneState.isMenuExpanded,
                selectedCountryCode = enterPhoneState.countryCode,
                onRowClickListener = { viewModel.updateIsMenuExpanded(true) },
                onDismissRequestClickListener = { viewModel.updateIsMenuExpanded(false) },
                onItemClickListener = {
                    viewModel.updateCountryCode(it)
                    viewModel.updateIsMenuExpanded(false)
                },
                onPhoneValueChangeClickListener = { viewModel.updatePhone(it) }) {
                onButtonClickListener(enterPhoneState.countryCode.countryCode + enterPhoneState.phone)
            }
        }
    }
}

@Composable
private fun EnterPhoneScreenContent(
    modifier: Modifier = Modifier,
    phone: String,
    expanded: Boolean,
    selectedCountryCode: DropdownMenuItems,
    onRowClickListener: () -> Unit,
    onDismissRequestClickListener: () -> Unit,
    onItemClickListener: (DropdownMenuItems) -> Unit,
    onPhoneValueChangeClickListener: (String) -> Unit,
    onButtonClickListener: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = MeetingTheme.dimensions.dimension168,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeading2Old(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension6),
            text = stringResource(id = R.string.enter_phone_number),
            textAlign = TextAlign.Center,
        )
        TextBody2(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension40),
            text = stringResource(
                id = R.string.we_will_send_a_confirmation_code_to_the_specified_number
            ),
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )
        CustomPhoneNumber(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension68),
            displayText = phone,
            expanded = expanded,
            selectedCountryCode = selectedCountryCode,
            onRowClickListener = onRowClickListener,
            onItemClickListener = { onItemClickListener(it) },
            onDismissRequestClickListener = onDismissRequestClickListener,
            onValueChangeClickListener = { onPhoneValueChangeClickListener(it) }
        )
        MyButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.resume),
            onClick = onButtonClickListener,
            enabled = phone.length == PHONE_LENGTH
        )
    }
}

@Preview
@Composable
private fun EnterPhoneScreenContentPreview() {
    EnterPhoneScreenContent(
        phone = mockUser.phone,
        expanded = false,
        selectedCountryCode = DropdownMenuItems.RUSSIA,
        onDismissRequestClickListener = {},
        onItemClickListener = {},
        onRowClickListener = {},
        onPhoneValueChangeClickListener = {}) {
    }
}

