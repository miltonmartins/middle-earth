package com.martins.milton.middle.earth.data.mapper

import com.martins.milton.middle.earth.data.source.remote.models.MoviesResponse
import com.martins.milton.middle.earth.domain.entity.Movie

fun MoviesResponse.mapToMovies(): List<Movie> = docs.map {
    Movie(
        name = it.name
    )
}