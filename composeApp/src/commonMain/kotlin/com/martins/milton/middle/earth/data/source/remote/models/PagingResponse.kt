package com.martins.milton.middle.earth.data.source.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class PagingResponse<T>(
    val docs: List<T>,
    val pages: Int
)