package com.martins.milton.middle.earth.common

import app.cash.paging.LoadStateError
import app.cash.paging.LoadStateLoading
import app.cash.paging.compose.LazyPagingItems

fun <T : Any> LazyPagingItems<T>.isLoading() =
    loadState.refresh is LoadStateLoading || loadState.append is LoadStateLoading

fun <T : Any> LazyPagingItems<T>.getError() =
    when {
        loadState.refresh is LoadStateError -> (loadState.refresh as LoadStateError).error.message
        loadState.append is LoadStateError -> (loadState.append as LoadStateError).error.message
        else -> null
    }