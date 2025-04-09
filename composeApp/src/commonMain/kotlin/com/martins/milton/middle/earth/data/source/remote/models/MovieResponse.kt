package com.martins.milton.middle.earth.data.source.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    val docs: List<MovieResponse>
)

@Serializable
data class MovieResponse(
    val name: String
)