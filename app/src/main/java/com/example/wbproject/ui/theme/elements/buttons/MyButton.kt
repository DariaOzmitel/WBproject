package com.example.wbproject.ui.theme.elements.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.NoRippleTheme
import com.example.wbproject.ui.theme.elements.text.TextSubheading2

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(vertical = MeetingTheme.dimensions.dimension12),
    primaryColor: Color = LightColors.brandColorDefault,
    pressedColor: Color = LightColors.brandColorDark,
    secondaryColor: Color = Color.White,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    text: String
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        val interactionSource: MutableInteractionSource =
            remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        Button(
            onClick = onClick, modifier = modifier.fillMaxWidth(),
            interactionSource = interactionSource,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = when (isPressed) {
                    true -> pressedColor
                    false -> primaryColor
                },
                contentColor = secondaryColor,
                disabledContainerColor = primaryColor.copy(alpha = 0.5F),
                disabledContentColor = secondaryColor
            ),
            contentPadding = contentPadding
        ) {
            TextSubheading2(text = text)
        }
    }
}