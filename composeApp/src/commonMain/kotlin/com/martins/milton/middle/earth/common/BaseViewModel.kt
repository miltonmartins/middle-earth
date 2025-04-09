package com.martins.milton.middle.earth.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel<UiState>(initialUiState: UiState) : ViewModel() {
    protected val _uiState = MutableStateFlow(initialUiState)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
}