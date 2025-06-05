package com.martins.milton.middle.earth.data.source.remote.datasource

import com.martins.milton.middle.earth.common.Constants
import com.martins.milton.middle.earth.common.ResultData
import com.martins.milton.middle.earth.common.getResults
import com.martins.milton.middle.earth.data.source.LordOfRingsDataSource
import com.martins.milton.middle.earth.data.source.remote.models.BookResponse
import com.martins.milton.middle.earth.data.source.remote.models.CharacterResponse
import com.martins.milton.middle.earth.data.source.remote.models.MovieResponse
import com.martins.milton.middle.earth.data.source.remote.models.PagingResponse
import io.ktor.client.HttpClient
import io.ktor.http.path

data class LordOfRingsDataSourceRemote(
    private val httpClient: HttpClient
) : LordOfRingsDataSource {
    override suspend fun getMovies(page: Int): ResultData<PagingResponse<MovieResponse>> {
        return httpClient.getResults {
            url {
                path(Constants.Api.Path.MOVIES)
                parameters.append(
                    name = Constants.Api.Param.PAGE,
                    value = page.toString()
                )
                parameters.append(
                    name = Constants.Api.Param.LIMIT,
                    value = Constants.Api.MIN_LIMIT.toString()
                )
            }
        }
    }

    override suspend fun getCharacters(
        page: Int,
        filter: String?
    ): ResultData<PagingResponse<CharacterResponse>> {
        return httpClient.getResults {
            url {
                path(Constants.Api.Path.CHARACTERS)
                parameters.append(
                    name = Constants.Api.Param.SORT,
                    value = Constants.Api.Param.SORT_BY_NAME_ASC
                )
                filter?.let {
                    parameters.append(
                        name = Constants.Api.Filter.NAME,
                        value = "/$filter/i"
                    )
                }
                parameters.append(
                    name = Constants.Api.Param.PAGE,
                    value = page.toString()
                )
                parameters.append(
                    name = Constants.Api.Param.LIMIT,
                    value = Constants.Api.MAX_LIMIT.toString()
                )
            }
        }
    }

    override suspend fun getBooks(page: Int): ResultData<PagingResponse<BookResponse>> {
        return httpClient.getResults {
            url {
                path(Constants.Api.Path.BOOKS)
                parameters.append(
                    name = Constants.Api.Param.PAGE,
                    value = page.toString()
                )
                parameters.append(
                    name = Constants.Api.Param.LIMIT,
                    value = Constants.Api.MAX_LIMIT.toString()
                )
            }
        }
    }
}