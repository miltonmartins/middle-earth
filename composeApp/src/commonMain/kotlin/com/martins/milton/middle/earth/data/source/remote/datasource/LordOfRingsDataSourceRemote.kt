package com.martins.milton.middle.earth.data.source.remote.datasource

import com.martins.milton.middle.earth.common.Constants
import com.martins.milton.middle.earth.common.ResultData
import com.martins.milton.middle.earth.common.getResults
import com.martins.milton.middle.earth.data.source.LordOfRingsDataSource
import com.martins.milton.middle.earth.data.source.remote.models.MovieResponse
import com.martins.milton.middle.earth.data.source.remote.models.PagingResponse
import io.ktor.client.HttpClient
import io.ktor.http.path

data class LordOfRingsDataSourceRemote(
    private val httpClient: HttpClient
) : LordOfRingsDataSource {
    override suspend fun getMovies(
        page: Int,
        limit: Int
    ): ResultData<PagingResponse<MovieResponse>> {
        return httpClient.getResults {
            url {
                path(Constants.Api.Path.MOVIES)
                parameters.append(
                    name = Constants.Api.Param.PAGE,
                    value = page.toString()
                )
                parameters.append(
                    name = Constants.Api.Param.LIMIT,
                    value = limit.toString()
                )
            }
        }
    }
}