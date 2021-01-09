package ru.dkkovalev.serics.shared.domain

import ru.dkkovalev.serics.shared.data.entity.response.MovieDto

interface MoviesUseCase : UseCase {
    suspend fun getMovies(query: String, page: Int): MovieDto
}