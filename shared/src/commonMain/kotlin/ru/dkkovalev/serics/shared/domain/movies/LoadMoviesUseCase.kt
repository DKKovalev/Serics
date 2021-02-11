package ru.dkkovalev.serics.shared.domain.movies

import ru.dkkovalev.serics.shared.data.entity.response.MovieDto

interface LoadMoviesUseCase {
    suspend fun getMovies(query: String, page: Int): MovieDto
}