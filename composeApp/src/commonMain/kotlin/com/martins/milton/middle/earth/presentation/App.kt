package com.martins.milton.middle.earth.presentation

import androidx.compose.runtime.Composable
import com.martins.milton.middle.earth.presentation.navigation.AppNavHost
import com.martins.milton.middle.earth.theming.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        AppTheme { AppNavHost() }
    }
}