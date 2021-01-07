package ru.dkkovalev.serics.shared.domain

import ru.dkkovalev.serics.shared.data.entity.response.MovieDto
import ru.dkkovalev.serics.shared.data.repos.MoviesRepo

class MoviesUseCaseImpl(private val repo: MoviesRepo) : MoviesUseCase {
    override suspend fun getMovies(query: String, page: Int): MovieDto = repo.getMovies(query, page)
}