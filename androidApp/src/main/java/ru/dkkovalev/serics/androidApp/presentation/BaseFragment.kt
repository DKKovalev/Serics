package ru.dkkovalev.serics.androidApp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding> : Fragment() {
    val viewBinding get() = binding
    abstract var binding: Binding?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding?.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}