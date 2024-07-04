package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.MyButtonArguments
import com.example.wbproject.ui.theme.arguments.MyOutlineButtonArguments

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        0.0f,
        0.0f,
        0.0f,
        0.0f
    )
}

@Composable
fun MyButton(
    args: MyButtonArguments
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        with(args) {
            val interactionSource: MutableInteractionSource =
                remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            Button(
                onClick = onClick, modifier = modifier,
                interactionSource = interactionSource,
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isPressed) pressedColor else primaryColor,
                    contentColor = secondaryColor,
                    disabledContainerColor = primaryColor.copy(alpha = 0.5F),
                    disabledContentColor = secondaryColor
                )
            ) {
                Text(text = text)
            }
        }

    }
}

@Composable
fun MyOutlinedButton(
    args: MyOutlineButtonArguments
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        with(args) {
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
                    color = if (enabled && !isPressed) primaryColor
                    else if (isPressed) pressedColor
                    else primaryColor.copy(
                        alpha = 0.5F
                    )
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = secondaryColor,
                    contentColor = if (isPressed) pressedColor else primaryColor,
                    disabledContentColor = primaryColor.copy(alpha = 0.5F),
                    disabledContainerColor = secondaryColor
                )
            ) {
                if (!isIcon) {
                    Text(text = text ?: "")
                } else {
                    Icon(
                        painter = painterResource(id = iconResId ?: R.drawable.point),
                        contentDescription = null
                    )
                }


            }
        }

    }
}

@Composable
fun MyTextButton(
    args: MyButtonArguments
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        with(args) {
            val interactionSource: MutableInteractionSource =
                remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            TextButton(
                onClick = onClick,
                modifier = modifier,
                interactionSource = interactionSource,
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(
                    contentColor = if (isPressed) pressedColor else primaryColor,
                    containerColor = secondaryColor,
                    disabledContentColor = primaryColor.copy(alpha = 0.5F),
                    disabledContainerColor = secondaryColor
                )
            ) {
                Text(text = text)
            }
        }
    }
}

@Composable
fun MyButtonsRow(
    args: MyButtonArguments
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        MyButton(args = args)
        MyOutlinedButton(
            args = MyOutlineButtonArguments(
                primaryColor = args.primaryColor,
                enabled = args.enabled
            )
        )
        MyTextButton(args = args)
    }
}


@Preview
@Composable
fun MyButtonsPreview() {

    Column(modifier = Modifier.fillMaxWidth()) {
        MyButtonsRow(MyButtonArguments())
        MyButtonsRow(MyButtonArguments(primaryColor = MeetingTheme.colors.brandColorDark))
        MyButtonsRow(MyButtonArguments(enabled = false))
    }
}