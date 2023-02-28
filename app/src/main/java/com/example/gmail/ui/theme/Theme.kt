package com.example.gmail.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
val GmailThemeColors = lightColors(
    primary = Color(0xFFD5CDCB),
    primaryVariant = Color(0xFFCC3A2F),
    onPrimary = Color.White,
    secondary = Color(0xFF99BDFC),
    secondaryVariant = Color(0xFF1A73E8),
    onSecondary = Color(0xFFE9ECF1),
    surface = Color.White,
    onSurface = Color.Black,
)

@Composable
fun GmailTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = GmailThemeColors,
        typography = GmailTypography,
        shapes = AppShapes,
        content = content
    )
}