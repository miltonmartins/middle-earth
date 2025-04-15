package com.martins.milton.middle.earth.presentation.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.martins.milton.middle.earth.theming.DefaultElevation
import middle_earth.composeapp.generated.resources.Res
import middle_earth.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppBar(
    title: String = stringResource(Res.string.app_name),
    errorMessage: String? = null,
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            if (it.isNotBlank()) {
                snackbarHostState.showSnackbar(message = errorMessage)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                elevation = DefaultElevation
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h4
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        content = { innerPadding -> content(innerPadding) }
    )
}