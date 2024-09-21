package com.example.ui.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.R
import com.example.ui.elements.EventSwitch
import com.example.ui.elements.text.TextPrimary
import com.example.ui.theme.EventTheme

@Composable
internal fun TextSwitchRow(modifier: Modifier = Modifier, text: String) {
    Row(modifier = modifier.fillMaxWidth()) {
        TextPrimary(
            modifier = Modifier.weight(1f),
            text = text,
            color = EventTheme.colors.brandColorPurple
        )
        EventSwitch {
        }
    }
}

@Preview
@Composable
private fun TextSwitchRowPreview() {
    TextSwitchRow(text = stringResource(id = R.string.show_my_communities))
}