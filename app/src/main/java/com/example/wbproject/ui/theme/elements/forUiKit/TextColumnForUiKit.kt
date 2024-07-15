package com.example.wbproject.ui.theme.elements.forUiKit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.elements.text.TextBody2
import com.example.wbproject.ui.theme.elements.text.TextHeading1
import com.example.wbproject.ui.theme.elements.text.TextHeading2
import com.example.wbproject.ui.theme.elements.text.TextMetadata1
import com.example.wbproject.ui.theme.elements.text.TextMetadata2
import com.example.wbproject.ui.theme.elements.text.TextMetadata3
import com.example.wbproject.ui.theme.elements.text.TextSubheading1
import com.example.wbproject.ui.theme.elements.text.TextSubheading2

@Composable
fun TextColumnForUiKit(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        val colorForUiKit = MeetingTheme.colors.neutralActive
        TextHeading1(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextHeading2(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextSubheading1(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextSubheading2(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextBody1(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextBody2(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextMetadata1(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextMetadata2(text = stringResource(id = R.string.test_text), color = colorForUiKit)
        TextMetadata3(text = stringResource(id = R.string.test_text), color = colorForUiKit)
    }
}

@Preview
@Composable
private fun MyTextPreview() {
    TextColumnForUiKit()
}