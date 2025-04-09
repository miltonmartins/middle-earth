package com.martins.milton.middle.earth.domain.usecase

import com.martins.milton.middle.earth.domain.entity.Movie

fun interface GetMoviesUseCase: suspend () -> List<Movie>