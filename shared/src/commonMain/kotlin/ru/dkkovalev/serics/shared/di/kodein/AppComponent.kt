package ru.dkkovalev.serics.shared.di.kodein

import org.kodein.di.DI

val appComponent = DI.lazy {
    importAll(appModule, authModule, moviesModule, popularModule)
}