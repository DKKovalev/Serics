package ru.dkkovalev.serics.androidApp

import org.kodein.di.DI
import org.kodein.di.instance
import org.kodein.di.provider
import ru.dkkovalev.serics.androidApp.presentation.auth.AuthViewModel
import ru.dkkovalev.serics.androidApp.presentation.list.MoviesViewModel
import ru.dkkovalev.serics.androidApp.presentation.list.PopularMoviesListViewModel

val viewModelModule = DI.Module("viewModelModule") {
    bindViewModel<AuthViewModel>() with provider {
        AuthViewModel(instance(), instance(), instance())
    }

    bindViewModel<MoviesViewModel>() with provider {
        MoviesViewModel(instance(), instance())
    }

    bindViewModel<PopularMoviesListViewModel>() with provider {
        PopularMoviesListViewModel(instance("popularMovies"))
    }
}