package com.example.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.theme.EventTheme
import com.example.ui.theme.NoRippleTheme
@Composable
fun EventSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit,
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Box(
            modifier = modifier
                .width(EventTheme.dimensions.dimension48)
                .height(EventTheme.dimensions.dimension24)
                .background(
                    color = when (checked) {
                        true -> EventTheme.colors.brandColorPurple
                        false -> Color.Transparent
                    },
                    shape = RoundedCornerShape(EventTheme.dimensions.dimension68)
                )
                .padding(EventTheme.dimensions.dimension2)
                .clickable { onCheckedChange(!checked) },
            contentAlignment = if (checked) CenterEnd else CenterStart
        ) {
            Box(
                modifier = Modifier
                    .size(EventTheme.dimensions.dimension20)
                    .background(color = EventTheme.colors.fontColorWhite, shape = CircleShape)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewEventSwitch() {
    EventSwitch {}
}