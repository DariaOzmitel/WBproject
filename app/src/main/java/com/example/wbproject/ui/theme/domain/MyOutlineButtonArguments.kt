package com.example.wbproject.ui.theme.domain

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wbproject.ui.theme.LightColors

data class MyOutlineButtonArguments(
    val modifier: Modifier = Modifier,
    val primaryColor: Color = LightColors.brandColorDefault,
    val pressedColor: Color = LightColors.brandColorDark,
    val secondaryColor: Color = Color.White,
    val onClick: () -> Unit = {},
    val enabled: Boolean = true,
    val iconResId: Int? = null,
    val text: String? = null
)
