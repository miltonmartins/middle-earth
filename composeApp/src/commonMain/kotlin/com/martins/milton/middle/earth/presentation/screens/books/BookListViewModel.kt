package com.martins.milton.middle.earth.presentation.screens.books

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import app.cash.paging.PagingData
import com.martins.milton.middle.earth.common.BaseViewModel
import com.martins.milton.middle.earth.domain.entity.Book
import com.martins.milton.middle.earth.domain.usecase.GetBooksUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update

data class BookUiState(
    val books: Flow<PagingData<Book>> = emptyFlow()
)

class BookListViewModel(
    private val getBooksUseCase: GetBooksUseCase
) : BaseViewModel<BookUiState>(BookUiState()) {
    fun fetchBooks() {
        _uiState.update {
            it.copy(books = getBooksUseCase().cachedIn(viewModelScope))
        }
    }
}