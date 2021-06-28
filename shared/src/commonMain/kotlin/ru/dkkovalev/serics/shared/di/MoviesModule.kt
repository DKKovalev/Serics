package ru.dkkovalev.serics.shared.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import ru.dkkovalev.serics.shared.data.repos.MoviesRepo
import ru.dkkovalev.serics.shared.data.repos.MoviesRepoImpl
import ru.dkkovalev.serics.shared.domain.movies.GenreListUseCase
import ru.dkkovalev.serics.shared.domain.movies.LoadMoviesUseCase
import ru.dkkovalev.serics.shared.domain.movies.LoadMoviesUseCaseImpl
import ru.dkkovalev.serics.shared.domain.movies.MovieGenreListUseCaseImpl

val moviesModule = DI.Module("moviesModule") {
    bind<MoviesRepo>() with provider { MoviesRepoImpl(instance()) }
    bind<GenreListUseCase>() with provider { MovieGenreListUseCaseImpl(instance()) }
    bind<LoadMoviesUseCase>() with provider { LoadMoviesUseCaseImpl(instance()) }
}