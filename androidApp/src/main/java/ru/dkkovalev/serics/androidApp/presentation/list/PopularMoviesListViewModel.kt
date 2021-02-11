package ru.dkkovalev.serics.androidApp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dkkovalev.serics.shared.data.entity.model.Show
import ru.dkkovalev.serics.shared.domain.series.LoadPopularUseCase

class PopularMoviesListViewModel(private val useCase: LoadPopularUseCase) : ViewModel() {

    val popularMoviesLiveData: LiveData<List<Show>> get() = internalPopularMoviesLiveData
    private val internalPopularMoviesLiveData: MutableLiveData<List<Show>> = MutableLiveData()

    init {
        viewModelScope.launch {
            try {
                val shows = useCase.load()
                internalPopularMoviesLiveData.postValue(shows)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}