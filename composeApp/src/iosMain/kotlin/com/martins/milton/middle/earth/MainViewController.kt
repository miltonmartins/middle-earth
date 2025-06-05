package com.martins.milton.middle.earth

import androidx.compose.ui.window.ComposeUIViewController
import com.martins.milton.middle.earth.di.initKoin
import com.martins.milton.middle.earth.presentation.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }