package ru.dkkovalev.serics.shared.domain.movies

import ru.dkkovalev.serics.shared.data.entity.response.GenreDto

interface GenreListUseCase {
    suspend fun getGenres(): List<GenreDto>
}