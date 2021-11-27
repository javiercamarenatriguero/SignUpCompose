package com.akole.signupcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = SignUpColor.pink,
    primaryVariant = SignUpColor.pinkDark,
    secondary = SignUpColor.teal,
    secondaryVariant = SignUpColor.tealDark,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = SignUpColor.grey6,
    onSurface = SignUpColor.grey6,
    error = SignUpColor.red,
    onError = Color.White,
)

@Composable
fun SignUpComposeTheme(
    @Suppress("UNUSED_PARAMETER") darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}