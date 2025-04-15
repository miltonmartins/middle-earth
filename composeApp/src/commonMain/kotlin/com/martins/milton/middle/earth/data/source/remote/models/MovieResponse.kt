package com.martins.milton.middle.earth.data.source.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    val docs: List<MovieResponse>
)

@Serializable
data class MovieResponse(
    @SerialName("_id") val id: String,
    val name: String,
    val runtimeInMinutes: Long
)