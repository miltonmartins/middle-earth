package com.martins.milton.middle.earth.data.source

import app.cash.paging.Pager
import app.cash.paging.PagingConfig
import app.cash.paging.PagingData
import com.martins.milton.middle.earth.common.Constants
import com.martins.milton.middle.earth.common.ResultData
import com.martins.milton.middle.earth.common.ResultDataPagingSource
import com.martins.milton.middle.earth.common.map
import com.martins.milton.middle.earth.data.mapper.mapToBooks
import com.martins.milton.middle.earth.data.mapper.mapToCharacters
import com.martins.milton.middle.earth.data.mapper.mapToMovies
import com.martins.milton.middle.earth.domain.entity.Book
import com.martins.milton.middle.earth.domain.entity.Character
import com.martins.milton.middle.earth.domain.entity.Movie
import com.martins.milton.middle.earth.domain.repository.LordOfRingsRepository
import kotlinx.coroutines.flow.Flow

class LordOfRingsRepositoryImpl(
    private val dataSource: LordOfRingsDataSource
) : LordOfRingsRepository {
    override fun getMovies(): Flow<PagingData<Movie>> = getPagerFlow { page ->
        dataSource.getMovies(page = page).map {
            Pair(
                first = it.pages > page,
                second = it.docs.mapToMovies()
            )
        }
    }

    override fun getCharacters(filter: String?): Flow<PagingData<Character>> = getPagerFlow { page ->
        dataSource.getCharacters(
            page = page,
            filter = filter
        ).map {
            Pair(
                first = it.pages > page,
                second = it.docs.mapToCharacters()
            )
        }
    }

    override fun getBooks(): Flow<PagingData<Book>> = getPagerFlow { page ->
        dataSource.getBooks(page = page).map {
            Pair(
                first = it.pages > page,
                second = it.docs.mapToBooks()
            )
        }
    }

    private fun <T : Any> getPagerFlow(
        data: suspend (Int) -> ResultData<Pair<Boolean, List<T>>>
    ) = Pager(
        config = PagingConfig(pageSize = Constants.Api.MIN_LIMIT),
        pagingSourceFactory = {
            ResultDataPagingSource { page, _ ->
                data(page)
            }
        }
    ).flow
}