package com.martins.milton.middle.earth.presentation.navigation

sealed class AppDestination(val route: String) {
    data object Movies : AppDestination("movies")
    data object Characters : AppDestination("characters")
    data object Books : AppDestination("books")
}