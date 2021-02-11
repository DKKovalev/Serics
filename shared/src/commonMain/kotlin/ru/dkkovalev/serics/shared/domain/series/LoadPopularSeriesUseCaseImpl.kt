package ru.dkkovalev.serics.shared.domain.series

import ru.dkkovalev.serics.shared.data.entity.model.Show
import ru.dkkovalev.serics.shared.data.repos.PopularRepo

class LoadPopularSeriesUseCaseImpl(private val popularRepo: PopularRepo) : LoadPopularUseCase {
    override suspend fun load(): List<Show> = popularRepo.getPopularSeries()
}