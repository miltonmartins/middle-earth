package com.martins.milton.middle.earth.data.source

import com.martins.milton.middle.earth.common.ResultData
import com.martins.milton.middle.earth.data.source.remote.models.BookResponse
import com.martins.milton.middle.earth.data.source.remote.models.CharacterResponse
import com.martins.milton.middle.earth.data.source.remote.models.MovieResponse
import com.martins.milton.middle.earth.data.source.remote.models.PagingResponse

interface LordOfRingsDataSource {
    suspend fun getMovies(page: Int): ResultData<PagingResponse<MovieResponse>>
    suspend fun getCharacters(
        page: Int,
        filter: String?
    ): ResultData<PagingResponse<CharacterResponse>>
    suspend fun getBooks(page: Int): ResultData<PagingResponse<BookResponse>>
}