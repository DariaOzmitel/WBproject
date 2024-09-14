package com.example.ui.screen.profile.deleteProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockMeeting
import com.example.ui.R
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.text.TextHeadingHuge
import com.example.ui.elements.text.TextRegular19
import com.example.ui.theme.EventTheme

@Composable
fun DeleteProfileScreen(modifier: Modifier = Modifier) {
    val meeting = mockMeeting
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = EventTheme.dimensions.dimension16,
                    bottom = innerPadding.calculateBottomPadding() + EventTheme.dimensions.dimension28,
                    end = EventTheme.dimensions.dimension16
                )
        ) {
            Row(modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension14)) {
                TextHeadingHuge(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.confirm_delete)
                )
                Image(
                    modifier = Modifier
                        .padding(top = EventTheme.dimensions.dimension10)
                        .size(EventTheme.dimensions.dimension28),
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = ""
                )
            }
            TextRegular19(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                text = stringResource(id = R.string.confirm_delete_text1)
            )
            TextRegular19(
                text = stringResource(id = R.string.confirm_delete_text2)
            )
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                EventButton(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension20),
                    text = stringResource(id = R.string.delete),
                    secondaryStatus = true
                )
                EventButton(text = stringResource(id = R.string.no_need))
            }
        }
    }
}

@Preview
@Composable
private fun DeleteProfileScreenPreview() {
    DeleteProfileScreen()
}