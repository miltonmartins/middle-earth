package com.martins.milton.middle.earth.presentation.composables

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.martins.milton.middle.earth.presentation.navigation.AppDestination
import middle_earth.composeapp.generated.resources.Res
import middle_earth.composeapp.generated.resources.navigation_books
import middle_earth.composeapp.generated.resources.navigation_characters
import middle_earth.composeapp.generated.resources.navigation_movies
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(modifier = Modifier.navigationBarsPadding()) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        listOf(
            BottomNavItem.Movies,
            BottomNavItem.Characters,
            BottomNavItem.Books
        ).forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(stringResource(item.label)) }
            )
        }
    }
}

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: StringResource
) {
    data object Movies : BottomNavItem(
        route = AppDestination.Movies.route,
        icon = Icons.Default.Movie,
        label = Res.string.navigation_movies
    )

    data object Characters : BottomNavItem(
        route = AppDestination.Characters.route,
        icon = Icons.Default.Person,
        label = Res.string.navigation_characters
    )

    data object Books : BottomNavItem(
        route = AppDestination.Books.route,
        icon = Icons.Default.Book,
        label = Res.string.navigation_books
    )
}
