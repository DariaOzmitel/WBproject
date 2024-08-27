package com.example.wbproject.ui.theme.deprecatedUi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.wbproject.R

private val interFamily = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_bold, FontWeight.Bold)
)

@Immutable
data class EventTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val heading4: TextStyle,
    val headingHuge: TextStyle,
    val primary: TextStyle,
    val secondary: TextStyle,
    val regular20: TextStyle,
)

private val myScale = 1.25

val EventTypographyValue = EventTypography(
    heading1 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = myScale * 34.sp
    ),
    heading2 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = myScale * 24.sp
    ),
    heading3 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = myScale * 18.sp
    ),
    heading4 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = myScale * 14.sp
    ),
    headingHuge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = myScale * 50.sp
    ),
    primary = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = myScale * 18.sp
    ),
    secondary = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = myScale * 14.sp
    ),
    regular20 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = myScale * 20.sp
    ),
)

internal val LocalEventTypography = staticCompositionLocalOf { EventTypographyValue }
