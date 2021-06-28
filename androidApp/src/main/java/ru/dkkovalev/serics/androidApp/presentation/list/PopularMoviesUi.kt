package ru.dkkovalev.serics.androidApp.presentation.list

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.util.ViewPreloadSizeProvider
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance
import ru.dkkovalev.serics.androidApp.fragmentViewModel
import ru.dkkovalev.serics.androidApp.presentation.BaseUi
import ru.dkkovalev.serics.shared.data.entity.model.Show

class PopularMoviesUi(fragment: ListFragment) : BaseUi<ListFragment>(fragment), DIAware {

    override val di: DI by lazy { fragment.di }

    private val vm: PopularMoviesListViewModel by fragment.fragmentViewModel()
    private val requestManager: RequestManager by instance(arg = fragment)
    private val popularShowsAdapter: PopularShowsAdapter by instance(arg = requestManager)
    private val linearLayoutManager: LinearLayoutManager by instance(arg = fragment.requireContext())
    private val divider: DividerItemDecoration by instance(arg = fragment.requireContext())

    private val preloader: RecyclerViewPreloader<Show> = RecyclerViewPreloader(
        requestManager,
        popularShowsAdapter,
        ViewPreloadSizeProvider(),
        10
    ) //TODO Inject this maybe?

    override fun onViewCreated(fragment: ListFragment) {
        val view = fragment.viewBinding
            ?: throw IllegalStateException("Fragment's ViewBinding cannot be null")

        with(view.popularMoviesList) {
            adapter = popularShowsAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(preloader)
            addItemDecoration(divider)
        }

        vm.popularMoviesLiveData.observe(
            fragment.viewLifecycleOwner,
            popularShowsAdapter::submitList
        )
    }
}
