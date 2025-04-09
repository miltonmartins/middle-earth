package com.martins.milton.middle.earth.data.source.remote.datasource

import com.martins.milton.middle.earth.data.source.LordOfRingsDataSource
import com.martins.milton.middle.earth.data.source.remote.models.MoviesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

data class LordOfRingsDataSourceRemote(
    private val httpClient: HttpClient
): LordOfRingsDataSource {
    override suspend fun getMovies(): MoviesResponse {
        return httpClient.get("movie").body<MoviesResponse>()
    }
}