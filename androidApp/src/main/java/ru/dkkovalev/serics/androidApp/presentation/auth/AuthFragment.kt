package ru.dkkovalev.serics.androidApp.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI
import ru.dkkovalev.serics.androidApp.databinding.FragmentAuthBinding
import ru.dkkovalev.serics.androidApp.fragmentViewModel

class AuthFragment : Fragment(), DIAware {

    companion object {
        fun newInstance(): AuthFragment = AuthFragment()
    }

    override val di: DI by closestDI()

    private val viewModel: AuthViewModel by fragmentViewModel()

    private var binding: FragmentAuthBinding? = null
    private val fragmentBinding get() = binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("!!! viewModel = $viewModel")

        fragmentBinding?.text?.text = "Hello from auth fragment"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}