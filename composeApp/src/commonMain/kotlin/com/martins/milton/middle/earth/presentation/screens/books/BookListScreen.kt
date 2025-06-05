package com.martins.milton.middle.earth.presentation.screens.books

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import app.cash.paging.compose.collectAsLazyPagingItems
import com.martins.milton.middle.earth.common.getError
import com.martins.milton.middle.earth.common.isLoading
import com.martins.milton.middle.earth.presentation.composables.AppBar
import com.martins.milton.middle.earth.presentation.composables.InfoItem
import com.martins.milton.middle.earth.presentation.composables.RefreshBox
import com.martins.milton.middle.earth.theming.MediumSpacing
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreen(
    navController: NavController,
    viewModel: BookListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val books = uiState.books.collectAsLazyPagingItems()

    LaunchedEffect(Unit) { viewModel.fetchBooks() }

    AppBar(
        navController = navController,
        errorMessage = books.getError()
    ) { innerPadding ->
        RefreshBox(
            modifier = Modifier.padding(innerPadding),
            onRefresh = viewModel::fetchBooks,
            loading = books.isLoading()
        ) {
            LazyColumn(modifier = Modifier.padding(MediumSpacing)) {
                items(
                    count = books.itemCount,
                    key = { books[it]?.id.orEmpty() }
                ) { index ->
                    books[index]?.let { book ->
                        InfoItem(
                            title = book.name,
                            description = ""
                        )
                    }
                }
            }
        }
    }
}