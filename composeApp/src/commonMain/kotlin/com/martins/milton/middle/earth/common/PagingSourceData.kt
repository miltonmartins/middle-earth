package com.martins.milton.middle.earth.common

import app.cash.paging.PagingSource
import app.cash.paging.PagingState

open class ResultDataPagingSource<T : Any>(
    private val pagingData: suspend (page: Int, pageSize: Int) -> ResultData<Pair<Boolean, List<T>>>
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> =
        (params.key ?: 1).let { currentPage ->
            try {
                pagingData(currentPage, params.loadSize)
                    .run {
                        when (this) {
                            is ResultData.Success -> {
                                LoadResult.Page(
                                    data = data.second,
                                    prevKey = currentPage.takeIf { it > 1 }?.dec(),
                                    nextKey = currentPage.takeIf { data.first }?.inc()
                                )
                            }
                            is ResultData.Error -> LoadResult.Error(Throwable(message))
                            else -> LoadResult.Error(IllegalStateException("$this type of [ResultData] is not allowed here"))
                        }
                    }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
}