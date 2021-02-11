package ru.dkkovalev.serics.shared.domain.movies

import ru.dkkovalev.serics.shared.data.entity.response.MovieDto
import ru.dkkovalev.serics.shared.data.repos.MoviesRepo

class LoadMoviesUseCaseImpl(private val repo: MoviesRepo) : LoadMoviesUseCase {
    override suspend fun getMovies(query: String, page: Int): MovieDto = repo.getMovies(query, page)
}