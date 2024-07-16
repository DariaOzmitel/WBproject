package com.example.wbproject.ui.theme.screens.more

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.IconInCircle
import com.example.wbproject.ui.theme.elements.buttons.MyOutlinedButton
import com.example.wbproject.ui.theme.elements.text.TextHeading1
import com.example.wbproject.ui.theme.elements.text.TextSubheading2

@Preview
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension136,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconInCircle(
            size = MeetingTheme.dimensions.dimension200, painter = painterResource(
                id = R.drawable.user
            )
        )
        TextHeading1(
            modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension16),
            text = stringResource(id = R.string.test_profile_name),
        )
        TextSubheading2(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension40),
            text = stringResource(id = R.string.test_profile_phone),
            color = MeetingTheme.colors.neutralDisabled
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MyOutlinedButton(
                modifier = Modifier
                    .width(MeetingTheme.dimensions.dimension72)
                    .height(MeetingTheme.dimensions.dimension40),
                iconResId = R.drawable.twitter
            )
            MyOutlinedButton(
                modifier = Modifier
                    .width(MeetingTheme.dimensions.dimension72)
                    .height(MeetingTheme.dimensions.dimension40),
                iconResId = R.drawable.instagram
            )
            MyOutlinedButton(
                modifier = Modifier
                    .width(MeetingTheme.dimensions.dimension72)
                    .height(MeetingTheme.dimensions.dimension40),
                iconResId = R.drawable.linked_in
            )
            MyOutlinedButton(
                modifier = Modifier
                    .width(MeetingTheme.dimensions.dimension72)
                    .height(MeetingTheme.dimensions.dimension40),
                iconResId = R.drawable.facebook
            )
        }
    }

}