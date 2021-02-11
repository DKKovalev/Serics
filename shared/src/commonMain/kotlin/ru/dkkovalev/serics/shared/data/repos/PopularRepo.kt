package ru.dkkovalev.serics.shared.data.repos

import ru.dkkovalev.serics.shared.data.entity.model.Show

interface PopularRepo {
    suspend fun getPopularSeries(): List<Show>
    suspend fun getPopularMovies(): List<Show>
}