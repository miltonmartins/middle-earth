package com.martins.milton.middle.earth.domain.usecase

import app.cash.paging.PagingData
import com.martins.milton.middle.earth.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

fun interface GetMoviesUseCase: () -> Flow<PagingData<Movie>>