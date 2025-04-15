package com.martins.milton.middle.earth.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.martins.milton.middle.earth.presentation.screens.movies.MovieListScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Movies.route,
    ) {
        composable(route = AppDestination.Movies.route) {
            MovieListScreen(navController = navController)
        }
    }
}