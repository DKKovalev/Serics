package ru.dkkovalev.serics.androidApp.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

abstract class BaseUi<F : Fragment>(private val fragment: F) : LifecycleObserver {

    init {
        fragment.viewLifecycleOwnerLiveData.observe(fragment, { subscribeToLifecycle() })
    }

    private fun subscribeToLifecycle() {
        fragment.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate(owner: LifecycleOwner) {
                onViewCreated(fragment)
            }
        })
    }

    abstract fun onViewCreated(fragment: F)
}