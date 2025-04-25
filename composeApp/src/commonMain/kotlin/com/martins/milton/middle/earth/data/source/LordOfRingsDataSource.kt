package com.martins.milton.middle.earth.data.source

import com.martins.milton.middle.earth.common.ResultData
import com.martins.milton.middle.earth.data.source.remote.models.MovieResponse
import com.martins.milton.middle.earth.data.source.remote.models.PagingResponse

interface LordOfRingsDataSource {
    suspend fun getMovies(page: Int, limit: Int): ResultData<PagingResponse<MovieResponse>>
}