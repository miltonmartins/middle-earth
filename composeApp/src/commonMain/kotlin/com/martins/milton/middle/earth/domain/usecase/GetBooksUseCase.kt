package com.martins.milton.middle.earth.domain.usecase

import app.cash.paging.PagingData
import com.martins.milton.middle.earth.domain.entity.Book
import kotlinx.coroutines.flow.Flow

fun interface GetBooksUseCase : () -> Flow<PagingData<Book>>