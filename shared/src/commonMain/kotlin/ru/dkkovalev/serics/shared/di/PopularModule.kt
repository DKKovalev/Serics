package ru.dkkovalev.serics.shared.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import ru.dkkovalev.serics.shared.data.repos.PopularRepo
import ru.dkkovalev.serics.shared.data.repos.PopularRepoImpl
import ru.dkkovalev.serics.shared.domain.series.LoadPopularMoviesUseCaseImpl
import ru.dkkovalev.serics.shared.domain.series.LoadPopularSeriesUseCaseImpl
import ru.dkkovalev.serics.shared.domain.series.LoadPopularUseCase

val popularModule = DI.Module("popularModule") {
    bind<PopularRepo>() with provider { PopularRepoImpl(instance()) }
    bind<LoadPopularUseCase>("popularMovies") with provider { LoadPopularMoviesUseCaseImpl(instance()) }
    bind<LoadPopularUseCase>("popularSeries") with provider { LoadPopularSeriesUseCaseImpl(instance()) }
}