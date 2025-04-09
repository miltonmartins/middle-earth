package com.martins.milton.middle.earth.presentation

import androidx.compose.runtime.Composable
import com.martins.milton.middle.earth.di.module.ktorModule
import com.martins.milton.middle.earth.di.module.sharedAppModule
import com.martins.milton.middle.earth.presentation.screens.movies.MovieListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(
                sharedAppModule,
                ktorModule
            )
        }
    ) {
        MovieListScreen()
    }
}