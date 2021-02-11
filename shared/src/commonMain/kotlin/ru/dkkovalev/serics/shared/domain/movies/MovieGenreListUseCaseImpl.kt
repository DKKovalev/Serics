package ru.dkkovalev.serics.shared.domain.movies

import ru.dkkovalev.serics.shared.data.entity.response.GenreDto
import ru.dkkovalev.serics.shared.data.repos.MoviesRepo

class MovieGenreListUseCaseImpl(private val repo: MoviesRepo) : GenreListUseCase {

    override suspend fun getGenres(): List<GenreDto> = repo.getGenres().genreList
}