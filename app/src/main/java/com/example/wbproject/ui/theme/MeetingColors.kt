package com.example.wbproject.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class MeetingColors(
    val brandColorDark: Color,
    val brandColorDefault: Color,
    val brandColorDarkMode: Color,
    val brandColorLight: Color,
    val brandColorBackGround: Color,
    val neutralDisabled: Color,
    val neutralLine: Color,
    val neutralOffWhite: Color,
    val neutralActive: Color,
    val neutralWeak: Color,
)

val LightColors = MeetingColors(
    brandColorDark = Color(0xFF660EC8),
    brandColorDefault = Color(0xFF9A41FE),
    brandColorDarkMode = Color(0xFF8207E8),
    brandColorLight = Color(0xFFECDAFF),
    brandColorBackGround = Color(0xFFF5ECFF),
    neutralDisabled = Color(0xFFADB5BD),
    neutralLine = Color(0xFFEDEDED),
    neutralOffWhite = Color(0xFFF7F7FC),
    neutralActive = Color(0xFF29183B),
    neutralWeak = Color(0xFFA4A4A4),
)
internal val LocalColors = staticCompositionLocalOf { LightColors }