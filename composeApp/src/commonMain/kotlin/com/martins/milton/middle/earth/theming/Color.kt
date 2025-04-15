package com.martins.milton.middle.earth.theming

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

// Light Theme Colors
val LightBackground = Color(0xFFFFFFFF)
val LightTextColor = Color(0xFFe3b737)
val LightError = Color(0xFFf44336)
val LightSurface = Color(0xFF402f21)

// Dark Theme Colors
val DarkBackground = Color(0xFF402f21)
val DarkTextColor = Color(0xFFe3b737)
val DarkError = Color(0xFFf44336)

internal val LightColorScheme = lightColors(
    primary = LightBackground,
    onPrimary = LightTextColor,
    background = LightBackground,
    onBackground = LightTextColor,
    surface = LightSurface,
    onSurface = LightTextColor,
    secondary = LightBackground,
    onSecondary = LightTextColor,
    primaryVariant = DarkBackground,
    secondaryVariant = DarkBackground,
    error = LightError,
    onError = LightTextColor
)

internal val DarkColorScheme = darkColors(
    primary = DarkBackground,
    onPrimary = DarkTextColor,
    background = DarkBackground,
    onBackground = DarkTextColor,
    surface = DarkBackground,
    onSurface = DarkTextColor,
    secondary = DarkBackground,
    onSecondary = DarkTextColor,
    primaryVariant = DarkBackground,
    secondaryVariant = DarkBackground,
    error = DarkError,
    onError = DarkTextColor
)