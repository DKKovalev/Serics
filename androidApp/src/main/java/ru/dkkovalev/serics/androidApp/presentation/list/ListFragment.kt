package ru.dkkovalev.serics.androidApp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.android.x.closestDI
import org.kodein.di.instance
import ru.dkkovalev.serics.androidApp.databinding.FragmentMoviesBinding
import ru.dkkovalev.serics.androidApp.presentation.BaseFragment

class ListFragment : BaseFragment<FragmentMoviesBinding>(), DIAware {

    override val di: DI by closestDI()
    override val diTrigger: DITrigger = DITrigger()

    override var binding: FragmentMoviesBinding? = null

    private val moviesUi: PopularMoviesUi by instance(arg = this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        diTrigger.trigger()
    }
}