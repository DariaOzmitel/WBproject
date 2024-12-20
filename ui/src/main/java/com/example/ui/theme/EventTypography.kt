package com.example.wbproject.ui.theme.deprecatedUi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.ui.R

private val interFamily = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
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
    val regular19: TextStyle,
    val regular20: TextStyle,
    val medium16: TextStyle,
    val medium19: TextStyle,
    val medium22: TextStyle,
)

private val myScale = 1.2

val EventTypographyValue = EventTypography(
    heading1 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = myScale * 34.sp
    ),
    heading2 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = myScale * 24.sp
    ),
    heading3 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = myScale * 18.sp
    ),
    heading4 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = myScale * 14.sp
    ),
    headingHuge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = myScale * 50.sp,
        lineHeight = myScale * 44.sp
    ),
    primary = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = myScale * 18.sp
    ),
    secondary = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = myScale * 14.sp
    ),
    regular19 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = myScale * 19.sp
    ),
    regular20 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = myScale * 20.sp
    ),
    medium16 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = myScale * 16.sp
    ),
    medium19 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = myScale * 19.sp
    ),
    medium22 = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = myScale * 22.sp
    ),
)

internal val LocalEventTypography = staticCompositionLocalOf { EventTypographyValue }
