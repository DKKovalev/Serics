package ru.dkkovalev.serics.androidApp

import org.kodein.di.*
import ru.dkkovalev.serics.androidApp.presentation.list.ListFragment
import ru.dkkovalev.serics.androidApp.presentation.list.MoviesUi

val uiModule = DI.Module("uiModule") {
    bind<ListFragment>("list fragment") with singleton { ListFragment() }
    bind<MoviesUi>() with provider { MoviesUi(instance()) }
}