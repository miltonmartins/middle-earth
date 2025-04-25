package com.martins.milton.middle.earth.presentation.screens.movies

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import app.cash.paging.compose.collectAsLazyPagingItems
import com.martins.milton.middle.earth.common.getError
import com.martins.milton.middle.earth.common.isLoading
import com.martins.milton.middle.earth.presentation.composables.AppBar
import com.martins.milton.middle.earth.presentation.composables.MovieItem
import com.martins.milton.middle.earth.presentation.composables.RefreshBox
import com.martins.milton.middle.earth.theming.MediumSpacing
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val movies = uiState.movies.collectAsLazyPagingItems()

    LaunchedEffect(Unit) { viewModel.fetchMovies() }

    AppBar(
        navController = navController,
        errorMessage = movies.getError()
    ) { innerPadding ->
        RefreshBox(
            modifier = Modifier.padding(innerPadding),
            onRefresh = viewModel::fetchMovies,
            loading = movies.isLoading()
        ) {
            LazyColumn(modifier = Modifier.padding(MediumSpacing)) {
                items(
                    count = movies.itemCount,
                    key = { movies[it]?.id.orEmpty() }
                ) { index ->
                    movies[index]?.let { movie -> MovieItem(movie) }
                }
            }
        }
    }
}