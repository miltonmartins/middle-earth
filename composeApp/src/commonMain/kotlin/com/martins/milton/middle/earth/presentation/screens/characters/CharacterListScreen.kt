package com.martins.milton.middle.earth.presentation.screens.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import app.cash.paging.compose.collectAsLazyPagingItems
import com.martins.milton.middle.earth.common.BrowserTab
import com.martins.milton.middle.earth.common.getError
import com.martins.milton.middle.earth.common.isLoading
import com.martins.milton.middle.earth.presentation.composables.AppBar
import com.martins.milton.middle.earth.presentation.composables.InfoItem
import com.martins.milton.middle.earth.presentation.composables.RefreshBox
import com.martins.milton.middle.earth.presentation.composables.SearchTextField
import com.martins.milton.middle.earth.theming.MediumSpacing
import middle_earth.composeapp.generated.resources.Res
import middle_earth.composeapp.generated.resources.filter_by_name
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val characters = uiState.characters.collectAsLazyPagingItems()
    val browserTab = koinInject<BrowserTab>()

    AppBar(
        navController = navController,
        errorMessage = characters.getError()
    ) { innerPadding ->
        RefreshBox(
            modifier = Modifier.padding(innerPadding),
            onRefresh = viewModel::fetchCharacters,
            loading = characters.isLoading()
        ) {
            Column {
                Box(modifier = Modifier.padding(horizontal = MediumSpacing)) {
                    SearchTextField(
                        hint = stringResource(Res.string.filter_by_name),
                        onTextChange = viewModel::fetchCharacters
                    )
                }
                LazyColumn(modifier = Modifier.padding(MediumSpacing)) {
                    items(
                        count = characters.itemCount,
                        key = { characters[it]?.id.orEmpty() }
                    ) { index ->
                        characters[index]?.let { character ->
                            InfoItem(
                                title = character.name,
                                description = character.race,
                                url = character.wikiUrl,
                                onClick = browserTab::open
                            )
                        }
                    }
                }
            }
        }
    }
}