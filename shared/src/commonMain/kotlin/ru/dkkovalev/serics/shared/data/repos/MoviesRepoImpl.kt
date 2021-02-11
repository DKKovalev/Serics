package ru.dkkovalev.serics.shared.data.repos

import ru.dkkovalev.serics.shared.data.api.TmdbApi

class MoviesRepoImpl(private val api: TmdbApi) : MoviesRepo {
    override suspend fun getMovies(query: String, page: Int) = api.getMoviesList(query, page)
    override suspend fun getGenres() = api.getMovieGenres()
}