package com.martins.milton.middle.earth.data.mapper

import com.martins.milton.middle.earth.data.source.remote.models.MoviesResponse
import com.martins.milton.middle.earth.domain.entity.Movie
import kotlin.time.Duration.Companion.minutes

fun MoviesResponse.mapToMovies(): List<Movie> = docs.map {
    Movie(
        id = it.id,
        name = it.name,
        time = it.runtimeInMinutes.minutes.toComponents { hours, minutes, _, _ -> "${hours}h:${minutes}m" }
    )
}