package ru.dkkovalev.serics.shared

import com.russhwolf.settings.Settings
import ru.dkkovalev.serics.shared.data.api.HttpClientFactory
import ru.dkkovalev.serics.shared.data.api.TmdbApiImpl
import ru.dkkovalev.serics.shared.data.repos.MoviesRepo
import ru.dkkovalev.serics.shared.data.repos.MoviesRepoImpl
import ru.dkkovalev.serics.shared.domain.MoviesUseCase
import ru.dkkovalev.serics.shared.domain.MoviesUseCaseImpl

class SericsSDK(
    private val language: String,
    private val isDebug: Boolean,
    private val httpClientFactory: HttpClientFactory,
    private val settings: Settings
) {
    companion object {}

    private val tmdbApi = TmdbApiImpl(httpClientFactory.create(isDebug), language)
    private val moviesRepo: MoviesRepo = MoviesRepoImpl(tmdbApi)

    fun getMoviesUseCase(): MoviesUseCase = MoviesUseCaseImpl(moviesRepo)
}