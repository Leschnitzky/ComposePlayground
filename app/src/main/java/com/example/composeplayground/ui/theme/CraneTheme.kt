package com.example.composeplayground.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val crane_caption = Color.DarkGray
val crane_divider_color = Color.LightGray
val crane_red = Color(0xFFE30425)
private val crane_white = Color.White
private val crane_purple_700 = Color(0xFF720D5D)
private val crane_purple_800 = Color(0xFF5D1049)
private val crane_purple_900 = Color(0xFF4E0D3A)

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)

val playGroundColors = lightColors(
    primary = purple500,
    secondary = teal200,
    onSurface = crane_red,
    primaryVariant = purple700
)

val darkPlayGroundColors = darkColors(
    primary = crane_purple_800,
    secondary = crane_red,
    onSurface = crane_white,
    primaryVariant = crane_purple_700
)

val BottomSheetShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)

@Composable
fun CraneTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isDarkMode) darkPlayGroundColors else playGroundColors,
        shapes = composePlayGroundShapes,
        content = content
    )
}