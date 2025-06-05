package com.martins.milton.middle.earth.data.source.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    @SerialName("_id") val id: String,
    val name: String
)