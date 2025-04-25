package com.martins.milton.middle.earth.data.source

import app.cash.paging.Pager
import app.cash.paging.PagingConfig
import app.cash.paging.PagingData
import com.martins.milton.middle.earth.common.Constants
import com.martins.milton.middle.earth.common.ResultDataPagingSource
import com.martins.milton.middle.earth.common.map
import com.martins.milton.middle.earth.data.mapper.mapToMovies
import com.martins.milton.middle.earth.domain.entity.Movie
import com.martins.milton.middle.earth.domain.repository.LordOfRingsRepository
import kotlinx.coroutines.flow.Flow

class LordOfRingsRepositoryImpl(
    private val dataSource: LordOfRingsDataSource
) : LordOfRingsRepository {
    override fun getMovies(): Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(pageSize = 15),
        pagingSourceFactory = {
            ResultDataPagingSource { page, _ ->
                dataSource.getMovies(
                    page = page,
                    limit = Constants.Api.MIN_LIMIT
                ).map {
                    Pair(
                        first = it.pages > page,
                        second = it.docs.mapToMovies()
                    )
                }
            }
        }
    ).flow
}