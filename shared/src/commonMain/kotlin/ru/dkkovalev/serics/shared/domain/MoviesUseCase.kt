package ru.dkkovalev.serics.shared.domain

import ru.dkkovalev.serics.shared.data.entity.response.MovieDto

interface MoviesUseCase {
    suspend fun getMovies(query: String, page: Int): MovieDto
}