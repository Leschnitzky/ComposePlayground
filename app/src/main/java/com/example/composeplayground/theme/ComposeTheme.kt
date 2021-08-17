package com.example.composeplayground.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val primaryGreen = Color(0XFF00bc00)
val primaryCharcoal = Color(0xFF2b2b2b)
val accentAmber = Color(0xFFffe400)

val textColorLight = Color(0xDCFFFFFF)
val textColorDark = Color(0xFFf3f3f3)
val gridLineColorLight = Color.Black

private val LightColorPalette = lightColors(
    primary = primaryGreen,
    secondary = textColorLight,
    surface = textColorLight,
    primaryVariant = gridLineColorLight,
    onPrimary = accentAmber,
)

private val DarkColorPalette = darkColors(
    //main background color
    primary = primaryCharcoal,
    //used for text color
    secondary = textColorDark,
    //background of sudoku board
    surface = textColorLight,
    //grid lines of sudoku board
    primaryVariant = gridLineColorLight,
    onPrimary = accentAmber,

    onSurface = accentAmber

)

val typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

@Composable
fun ComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = typography,
        content = content
    )
}

