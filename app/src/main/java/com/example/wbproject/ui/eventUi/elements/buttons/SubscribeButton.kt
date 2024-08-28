package com.example.wbproject.ui.eventUi.elements.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.R
import com.example.wbproject.ui.eventUi.theme.EventTheme
import com.example.wbproject.ui.eventUi.theme.NoRippleTheme

@Composable
fun SubscribeButton(
    modifier: Modifier = Modifier,
    subscribeStatus: Boolean = false,
    onClick: () -> Unit = {},
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Button(
            onClick = onClick, modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(EventTheme.dimensions.dimension12))
                .addBackground(subscribeStatus),
            shape = RoundedCornerShape(0.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Unspecified,
                contentColor = when (subscribeStatus) {
                    true -> EventTheme.colors.fontColorWhite
                    false -> EventTheme.colors.brandColorPurple
                },
                disabledContainerColor = EventTheme.colors.neutralOffWhite,
                disabledContentColor = EventTheme.colors.neutralDisabled
            ),
            contentPadding = PaddingValues(EventTheme.dimensions.dimension8)
        ) {
            when (subscribeStatus) {
                true -> Icon(painter = painterResource(id = R.drawable.ok), contentDescription = "")
                false -> Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
private fun Modifier.addBackground(subscribeStatus: Boolean): Modifier {
    return when (subscribeStatus) {
        true -> this.background(EventTheme.colors.brandColorPurple)
        false -> this.background(EventTheme.colors.gradientWhite)
    }
}

@Preview
@Composable
private fun SubscribeButtonPreview() {
    SubscribeButton(subscribeStatus = true)
}