package com.example.wbproject.ui.theme.deprecatedUi.elements.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextSubheading2
import com.example.wbproject.ui.theme.deprecatedUi.theme.LightColors
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme
import com.example.wbproject.ui.theme.deprecatedUi.theme.NoRippleTheme

@Composable
fun MyTextButton(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(vertical = MeetingTheme.dimensions.dimension12),
    primaryColor: Color = LightColors.brandColorDefault,
    pressedColor: Color = LightColors.brandColorDark,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    text: String
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        val interactionSource: MutableInteractionSource =
            remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        TextButton(
            onClick = onClick,
            modifier = modifier,
            interactionSource = interactionSource,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                contentColor = when (isPressed) {
                    true -> pressedColor
                    false -> primaryColor
                },
                containerColor = Color.Transparent,
                disabledContentColor = primaryColor.copy(alpha = 0.5F),
                disabledContainerColor = Color.Transparent
            ),
            contentPadding = contentPadding
        ) {
            TextSubheading2(text = text)
        }
    }
}