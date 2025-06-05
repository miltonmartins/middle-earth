package com.martins.milton.middle.earth.domain.repository

import app.cash.paging.PagingData
import com.martins.milton.middle.earth.domain.entity.Character
import com.martins.milton.middle.earth.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface LordOfRingsRepository {
    fun getMovies(): Flow<PagingData<Movie>>
    fun getCharacters(filter: String?): Flow<PagingData<Character>>
}