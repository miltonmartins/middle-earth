package com.martins.milton.middle.earth.data.mapper

import com.martins.milton.middle.earth.data.source.remote.models.BookResponse
import com.martins.milton.middle.earth.data.source.remote.models.CharacterResponse
import com.martins.milton.middle.earth.data.source.remote.models.MovieResponse
import com.martins.milton.middle.earth.domain.entity.Book
import com.martins.milton.middle.earth.domain.entity.Character
import com.martins.milton.middle.earth.domain.entity.Movie
import kotlin.time.Duration.Companion.minutes

fun List<MovieResponse>.mapToMovies(): List<Movie> = map {
    Movie(
        id = it.id,
        name = it.name,
        time = it.runtimeInMinutes.minutes.toComponents { hours, minutes, _, _ -> "${hours}h:${minutes}m" }
    )
}

fun List<CharacterResponse>.mapToCharacters(): List<Character> = map {
    Character(
        id = it.id,
        name = it.name,
        race = it.race ?: "n/a",
        wikiUrl = it.wikiUrl
    )
}

fun List<BookResponse>.mapToBooks(): List<Book> = map {
    Book(
        id = it.id,
        name = it.name
    )
}