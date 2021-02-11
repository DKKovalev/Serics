package ru.dkkovalev.serics.shared.domain.series

import ru.dkkovalev.serics.shared.data.repos.PopularRepo

class LoadPopularMoviesUseCaseImpl(private val popularRepo: PopularRepo) : LoadPopularUseCase {
    override suspend fun load() = popularRepo.getPopularMovies()
}