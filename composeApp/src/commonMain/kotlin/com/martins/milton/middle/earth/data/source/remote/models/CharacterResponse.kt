package com.martins.milton.middle.earth.data.source.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("_id") val id: String,
    val name: String,
    val race: String?,
    val wikiUrl: String?
)