package com.martins.milton.middle.earth.data.source

import com.martins.milton.middle.earth.data.source.remote.models.MoviesResponse

interface LordOfRingsDataSource {
    suspend fun getMovies(): MoviesResponse
}