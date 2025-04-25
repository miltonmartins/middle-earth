package com.martins.milton.middle.earth.presentation.screens.movies

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import app.cash.paging.PagingData
import com.martins.milton.middle.earth.common.BaseViewModel
import com.martins.milton.middle.earth.domain.entity.Movie
import com.martins.milton.middle.earth.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update

data class MovieUiState(
    val movies: Flow<PagingData<Movie>> = emptyFlow()
)

class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : BaseViewModel<MovieUiState>(MovieUiState()) {
    fun fetchMovies() {
        _uiState.update {
            it.copy(movies = getMoviesUseCase().cachedIn(viewModelScope))
        }
    }
}