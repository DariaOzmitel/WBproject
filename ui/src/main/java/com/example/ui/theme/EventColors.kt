package com.example.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Immutable
data class EventColors(
    val brandColorPurple: Color,
    val fontColorBlack: Color,
    val fontColorGrey: Color,
    val fontColorWhite: Color,
    val fontColorRed: Color,
    val fontColorPink: Color,
    val neutralOffWhite: Color,
    val neutralDisabled: Color,
    val errorBackgroundColor: Color,
    val greenMetroColor: Color,
    val gradientPurple: Brush,
    val gradientWhite: Brush,
)

val LightColors = EventColors(
    brandColorPurple = Color(0xFF9A10F0),
    fontColorBlack = Color(0xFF000000),
    fontColorGrey = Color(0xFF76778E),
    fontColorWhite = Color(0xFFFFFFFF),
    fontColorRed = Color(0xFFFF0000),
    fontColorPink = Color(0xFFFF5C93),
    neutralOffWhite = Color(0xFFF6F6FA),
    neutralDisabled = Color(0xFFADB5BD),
    errorBackgroundColor = Color(0xFFFFEEF4),
    greenMetroColor = Color(0xFF00BF59),

    gradientPurple = Brush.horizontalGradient(
        listOf(
            Color(0xFFED3CCA), Color(0xFFDF34D2), Color(0xFFD02BD9),
            Color(0xFFBF22E1), Color(0xFFAE1AE8), Color(0xFF9A10F0),
            Color(0xFF8306F7), Color(0xFF6600FF)
        )
    ),
    gradientWhite = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    ),
)
internal val LocalColors = staticCompositionLocalOf { LightColors }