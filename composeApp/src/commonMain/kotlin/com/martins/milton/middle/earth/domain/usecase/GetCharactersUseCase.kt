package com.martins.milton.middle.earth.domain.usecase

import app.cash.paging.PagingData
import com.martins.milton.middle.earth.domain.entity.Character
import kotlinx.coroutines.flow.Flow

fun interface GetCharactersUseCase : (String?) -> Flow<PagingData<Character>>