package ru.dkkovalev.serics.shared.data.repos

import ru.dkkovalev.serics.shared.data.api.TmdbApi
import ru.dkkovalev.serics.shared.data.entity.model.Show
import ru.dkkovalev.serics.shared.data.entity.response.ResultDto
import ru.dkkovalev.serics.shared.data.mappers.toShow

class PopularRepoImpl(private val api: TmdbApi) : PopularRepo {

    override suspend fun getPopularMovies() = api.getPopularMovies()
        .results
        .map(ResultDto::toShow)

    override suspend fun getPopularSeries(): List<Show> = api.getPopularSeries()
        .results
        .map(ResultDto::toShow)
}