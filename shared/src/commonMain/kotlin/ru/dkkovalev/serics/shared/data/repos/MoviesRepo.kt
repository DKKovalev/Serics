package ru.dkkovalev.serics.shared.data.repos

import ru.dkkovalev.serics.shared.data.entity.response.MovieDto

interface MoviesRepo {
    suspend fun getMovies(query: String, page: Int): MovieDto
}