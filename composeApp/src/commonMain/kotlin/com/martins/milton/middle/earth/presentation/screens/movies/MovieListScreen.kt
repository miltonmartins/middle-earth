package com.martins.milton.middle.earth.presentation.screens.movies

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martins.milton.middle.earth.presentation.composables.RefreshBox
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) { viewModel.fetchMovies() }

    MaterialTheme {
        RefreshBox(
            onRefresh = viewModel::fetchMovies,
            loading = uiState.loading
        ) {
            LazyColumn {
                items(uiState.movies.size) {
                    val movie = uiState.movies[it]
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}