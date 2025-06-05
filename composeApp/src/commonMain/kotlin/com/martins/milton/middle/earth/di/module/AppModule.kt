package com.martins.milton.middle.earth.di.module

import com.martins.milton.middle.earth.data.source.LordOfRingsDataSource
import com.martins.milton.middle.earth.data.source.LordOfRingsRepositoryImpl
import com.martins.milton.middle.earth.data.source.remote.datasource.LordOfRingsDataSourceRemote
import com.martins.milton.middle.earth.domain.repository.LordOfRingsRepository
import com.martins.milton.middle.earth.domain.usecase.GetBooksUseCase
import com.martins.milton.middle.earth.domain.usecase.GetCharactersUseCase
import com.martins.milton.middle.earth.domain.usecase.GetMoviesUseCase
import com.martins.milton.middle.earth.presentation.screens.books.BookListViewModel
import com.martins.milton.middle.earth.presentation.screens.characters.CharacterListViewModel
import com.martins.milton.middle.earth.presentation.screens.movies.MovieListViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedAppModule = module {
    singleOf(::LordOfRingsDataSourceRemote) { bind<LordOfRingsDataSource>() }
    singleOf(::LordOfRingsRepositoryImpl) { bind<LordOfRingsRepository>() }
    single { GetMoviesUseCase(get<LordOfRingsRepository>()::getMovies) }
    single { GetCharactersUseCase(get<LordOfRingsRepository>()::getCharacters) }
    single { GetBooksUseCase(get<LordOfRingsRepository>()::getBooks) }

    viewModelOf(::MovieListViewModel)
    viewModelOf(::CharacterListViewModel)
    viewModelOf(::BookListViewModel)
}