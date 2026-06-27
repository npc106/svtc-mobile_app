package com.svtc.mobile.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors: ColorScheme = lightColorScheme(
    primary = Color(0xFF006B5B),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBDEFE3),
    onPrimaryContainer = Color(0xFF00201A),
    secondary = Color(0xFF8A5A00),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFDFA0),
    onSecondaryContainer = Color(0xFF2B1700),
    tertiary = Color(0xFF4C5F8F),
    background = Color(0xFFF8FAF9),
    surface = Color.White,
    surfaceVariant = Color(0xFFE4E8E6),
    outline = Color(0xFF737876)
)

private val DarkColors: ColorScheme = darkColorScheme(
    primary = Color(0xFF8AD3C4),
    onPrimary = Color(0xFF00382F),
    secondary = Color(0xFFEEC16D),
    tertiary = Color(0xFFB5C7FF)
)

@Composable
fun SVTCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = MaterialTheme.typography,
        content = content
    )
}
