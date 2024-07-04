package com.example.wbproject.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wbproject.R

private val sfProDisplayFamily = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
)

@Immutable
data class MeetingTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
    val bodyText1: TextStyle,
    val bodyText2: TextStyle,
    val metadata1: TextStyle,
    val metadata2: TextStyle,
    val metadata3: TextStyle,
)

val MeetingTypographyValue = MeetingTypography(
    heading1 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    heading2 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    subheading1 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    subheading2 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    bodyText1 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    bodyText2 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    metadata1 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    metadata2 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    metadata3 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp
    )
)

internal val LocalTypography = staticCompositionLocalOf { MeetingTypographyValue }
