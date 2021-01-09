package ru.dkkovalev.serics.shared.di

import org.kodein.di.DI

val appComponent = DI.lazy {
    importAll(appModule, authModule)
}