package com.martins.milton.middle.earth.domain.repository

import com.martins.milton.middle.earth.domain.entity.Movie

interface LordOfRingsRepository {
    suspend fun getMovies(): List<Movie>
}