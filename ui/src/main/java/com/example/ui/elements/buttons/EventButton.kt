package com.example.ui.elements.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.ButtonProgressIndicator
import com.example.ui.elements.text.TextHeading3
import com.example.ui.theme.EventTheme

@Composable
fun EventButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    secondaryStatus: Boolean = false,
    isLoading: Boolean = false,
    text: String,
    onClick: () -> Unit = {},
) {
//    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Button(
            onClick = onClick, modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(EventTheme.dimensions.dimension16))
                .background(
                    when (secondaryStatus) {
                        true -> EventTheme.colors.gradientWhite
                        false -> EventTheme.colors.gradientPurple
                    }
                ),
            enabled = enabled,
            shape = RoundedCornerShape(0.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Unspecified,
                contentColor = when (secondaryStatus) {
                    true -> EventTheme.colors.brandColorPurple
                    false -> EventTheme.colors.fontColorWhite
                },
                disabledContainerColor = EventTheme.colors.neutralOffWhite,
                disabledContentColor = EventTheme.colors.neutralDisabled
            ),
            contentPadding = PaddingValues(vertical = EventTheme.dimensions.dimension16)
        ) {
            when (isLoading) {
                true -> ButtonProgressIndicator()
                false -> TextHeading3(text = text)
            }
        }
    }
//}

@Preview
@Composable
private fun EventButtonPreview() {
    EventButton(text = stringResource(id = R.string.pay))
}