package ru.dkkovalev.serics.androidApp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.util.ViewPreloadSizeProvider
import org.kodein.di.*
import org.kodein.di.android.x.closestDI
import ru.dkkovalev.serics.androidApp.R
import ru.dkkovalev.serics.androidApp.databinding.FragmentMoviesBinding
import ru.dkkovalev.serics.androidApp.fragmentViewModel

class ListFragment : Fragment(), DIAware {

    override val di: DI by closestDI()
    override val diTrigger: DITrigger = DITrigger()

    private val viewModel: PopularMoviesListViewModel by fragmentViewModel()
    private var binding: FragmentMoviesBinding? = null

    private val fragmentBinding get() = binding

    private val moviesUi: MoviesUi by lazy { on(requireView()).direct.instance() }

    //private val moviesUi = MoviesUi(this)

    private lateinit var moviesAdapter: ShowsAdapter //TODO Inject this
    private lateinit var seriesAdapter: ShowsAdapter //TODO Inject this
    private val moviesLayoutManager = LinearLayoutManager(context).apply {
        orientation = LinearLayoutManager.HORIZONTAL
    }

    private val seriesLayoutManager = LinearLayoutManager(context).apply {
        orientation = LinearLayoutManager.HORIZONTAL
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diTrigger.trigger()

        moviesAdapter = ShowsAdapter(Glide.with(this))
        seriesAdapter = ShowsAdapter(Glide.with(this))

        fragmentBinding?.let { binding ->
            with(binding.popularMoviesList) {
                adapter = moviesAdapter
                layoutManager = moviesLayoutManager
                addOnScrollListener(
                    RecyclerViewPreloader(
                        Glide.with(this),
                        moviesAdapter,
                        ViewPreloadSizeProvider(),
                        10
                    )
                )
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        DividerItemDecoration.HORIZONTAL
                    ).apply {
                        setDrawable(ContextCompat.getDrawable(context, R.drawable.list_divider)!!)
                    })
            }

            binding.popularShowsList.adapter = seriesAdapter
            binding.popularShowsList.layoutManager = seriesLayoutManager

            /*viewModel.moviesLiveData.observe(viewLifecycleOwner, adapter::submitList)

            viewModel.loadingLiveData.observe(viewLifecycleOwner) {
                binding.loader.root.visibility = if (it) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }*/

            viewModel.popularMoviesLiveData.observe(viewLifecycleOwner, moviesAdapter::submitList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}