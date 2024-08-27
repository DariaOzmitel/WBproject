package com.example.wbproject.ui.theme.deprecatedUi.elements.forUiKit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.deprecatedUi.elements.buttons.MyButton
import com.example.wbproject.ui.theme.deprecatedUi.elements.buttons.MyOutlinedButton
import com.example.wbproject.ui.theme.deprecatedUi.elements.buttons.MyTextButton
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

@Composable
private fun ButtonsRowForUiKit(
    text: String,
    primaryColor: Color = MeetingTheme.colors.brandColorDefault,
    enabled: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        MyButton(text = text, primaryColor = primaryColor, enabled = enabled)
        MyOutlinedButton(
            primaryColor = primaryColor,
            enabled = enabled,
            text = text
        )
        MyTextButton(text = text, primaryColor = primaryColor, enabled = enabled)
    }
}


@Preview
@Composable
fun MyButtonsPreview() {

    Column(modifier = Modifier.fillMaxWidth()) {
        ButtonsRowForUiKit(
            text = stringResource(id = R.string.button)
        )
        ButtonsRowForUiKit(
            primaryColor = MeetingTheme.colors.brandColorDark,
            text = stringResource(id = R.string.button),
        )
        ButtonsRowForUiKit(
            text = stringResource(id = R.string.button), enabled = false
        )
    }
}