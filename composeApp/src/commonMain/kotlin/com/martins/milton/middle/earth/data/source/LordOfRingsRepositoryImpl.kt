package com.martins.milton.middle.earth.data.source

import com.martins.milton.middle.earth.data.mapper.mapToMovies
import com.martins.milton.middle.earth.domain.entity.Movie
import com.martins.milton.middle.earth.domain.repository.LordOfRingsRepository

class LordOfRingsRepositoryImpl(
    private val dataSource: LordOfRingsDataSource
) : LordOfRingsRepository {
    override suspend fun getMovies(): List<Movie> {
        return dataSource.getMovies().mapToMovies()
    }
}