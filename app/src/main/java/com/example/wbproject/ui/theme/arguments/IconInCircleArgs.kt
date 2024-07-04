package com.example.wbproject.ui.theme.arguments

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp

data class IconInCircleArgs(
    val size: Dp,
    val painter: Painter,
    val contentDescription: String = ""
)
