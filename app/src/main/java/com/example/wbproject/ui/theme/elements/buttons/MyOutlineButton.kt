package com.example.wbproject.ui.theme.elements.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.NoRippleTheme
import com.example.wbproject.ui.theme.elements.text.TextSubheading2

@Composable
fun MyOutlinedButton(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(vertical = MeetingTheme.dimensions.dimension12),
    primaryColor: Color = LightColors.brandColorDefault,
    pressedColor: Color = LightColors.brandColorDark,
    secondaryColor: Color = Color.White,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    @DrawableRes iconResId: Int? = null,
    text: String? = null
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        val interactionSource: MutableInteractionSource =
            remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
            border = BorderStroke(
                width = MeetingTheme.dimensions.dimension2,
                color = when {
                    enabled && !isPressed -> primaryColor
                    isPressed -> pressedColor
                    else -> primaryColor.copy(alpha = 0.5F)
                }
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondaryColor,
                contentColor = when (isPressed) {
                    true -> pressedColor
                    false -> primaryColor
                },
                disabledContentColor = primaryColor.copy(alpha = 0.5F),
                disabledContainerColor = secondaryColor
            ),
            contentPadding = contentPadding
        ) {
            text?.let {
                TextSubheading2(modifier = contentModifier, text = it)
            }
            iconResId?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = contentModifier,
                )
            }
        }
    }
}