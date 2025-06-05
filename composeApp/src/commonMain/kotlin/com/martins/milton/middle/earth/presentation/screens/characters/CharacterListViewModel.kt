package com.martins.milton.middle.earth.presentation.screens.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import app.cash.paging.PagingData
import com.martins.milton.middle.earth.common.BaseViewModel
import com.martins.milton.middle.earth.domain.entity.Character
import com.martins.milton.middle.earth.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update

data class CharacterUiState(
    val characters: Flow<PagingData<Character>> = emptyFlow()
)

class CharacterListViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : BaseViewModel<CharacterUiState>(CharacterUiState()) {
    fun fetchCharacters(filter: String? = null) {
        _uiState.update {
            it.copy(characters = getCharactersUseCase(filter).cachedIn(viewModelScope))
        }
    }
}