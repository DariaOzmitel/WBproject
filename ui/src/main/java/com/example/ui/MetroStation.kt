package com.example.ui

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.ui.theme.LightColors

internal enum class MetroStation(@StringRes val nameStringId: Int, val color: Color) {
    PRIMORSKAYA(nameStringId = R.string.primorskaya, color = LightColors.greenMetroColor)
}