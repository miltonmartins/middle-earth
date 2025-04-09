package com.martins.milton.middle.earth.presentation.screens.movies

import androidx.lifecycle.viewModelScope
import com.martins.milton.middle.earth.common.BaseViewModel
import com.martins.milton.middle.earth.common.ResultData
import com.martins.milton.middle.earth.common.launchAndGetData
import com.martins.milton.middle.earth.domain.entity.Movie
import com.martins.milton.middle.earth.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.flow.update

data class MovieUiState(
    val movies: List<Movie> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : BaseViewModel<MovieUiState>(MovieUiState()) {
    fun fetchMovies() {
        viewModelScope.launchAndGetData(
            block = { getMoviesUseCase() },
            onResult = { result ->
                when (result) {
                    is ResultData.Loading -> setLoading(result.loading)
                    is ResultData.Error -> setError(result.message)
                    is ResultData.Success -> setData(result.data)
                }
            }
        )
    }

    private fun setLoading(loading: Boolean) {
        _uiState.update { it.copy(loading = loading) }
    }

    private fun setError(message: String) {
        _uiState.update { it.copy(error = message) }
    }

    private fun setData(movies: List<Movie>) {
        _uiState.update { it.copy(movies = movies) }
    }
}