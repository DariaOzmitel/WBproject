package com.example.wbproject.ui.eventUi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class EventColors(
    val brandColorPurple: Color,
    val fontColorBlack: Color,
    val fontColorGrey: Color,
    val fontColorWhite: Color,
    val fontColorRed: Color,
    val fontColorPink: Color,
)

val LightColors = EventColors(
    brandColorPurple = Color(0xFF9A10F0),
    fontColorBlack = Color(0xFF000000),
    fontColorGrey = Color(0xFF76778E),
    fontColorWhite = Color(0xFFFFFFFF),
    fontColorRed = Color(0xFFFF0000),
    fontColorPink = Color(0xFFFF5C93),
)
internal val LocalColors = staticCompositionLocalOf { LightColors }