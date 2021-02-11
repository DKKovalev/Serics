package ru.dkkovalev.serics.androidApp.presentation.list

import org.kodein.di.DI
import org.kodein.di.DIAware
import ru.dkkovalev.serics.androidApp.fragmentViewModel
import ru.dkkovalev.serics.androidApp.presentation.BaseUi

class MoviesUi(fragment: ListFragment) : BaseUi<ListFragment>(fragment), DIAware {

    override val di: DI by lazy { fragment.di }
    private val vm: PopularMoviesListViewModel by fragment.fragmentViewModel()

    override fun onViewCreated() {
        println("!!! $vm")
    }
}
