package ru.dkkovalev.serics.shared.data.repos

import ru.dkkovalev.serics.shared.data.api.TmdbApi
import ru.dkkovalev.serics.shared.data.entity.response.MovieDto

class MoviesRepoImpl(private val api: TmdbApi) : MoviesRepo {
    override suspend fun getMovies(query: String, page: Int): MovieDto =
        api.getMoviesList(query, page)
}