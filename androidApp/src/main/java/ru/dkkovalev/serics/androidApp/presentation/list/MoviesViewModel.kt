package ru.dkkovalev.serics.androidApp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dkkovalev.serics.shared.data.entity.response.GenreDto
import ru.dkkovalev.serics.shared.data.entity.response.ResultDto
import ru.dkkovalev.serics.shared.domain.movies.GenreListUseCase
import ru.dkkovalev.serics.shared.domain.movies.LoadMoviesUseCase

class MoviesViewModel(
    private val movieGenreListUseCase: GenreListUseCase,
    private val moviesUseCase: LoadMoviesUseCase
) : ViewModel() {

    val genresLiveData: LiveData<List<GenreDto>> get() = internalGenresLiveData
    private val internalGenresLiveData: MutableLiveData<List<GenreDto>> = MutableLiveData()

    val selectedGenresLiveData: LiveData<List<String>> get() = internalSelectedGenresLiveData
    private val internalSelectedGenresLiveData: MutableLiveData<List<String>> = MutableLiveData()

    val moviesLiveData: LiveData<List<ResultDto>> get() = internalMoviesLiveData
    private val internalMoviesLiveData: MutableLiveData<List<ResultDto>> = MutableLiveData()

    val seriesLiveData: LiveData<List<ResultDto>> get() = internalSeriesLiveData
    private val internalSeriesLiveData: MutableLiveData<List<ResultDto>> = MutableLiveData()

    val loadingLiveData: LiveData<Boolean> get() = internalLoadingLiveData
    private val internalLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    private val selectedGenres: MutableSet<String> = mutableSetOf()

    init {
        internalLoadingLiveData.postValue(true)

        viewModelScope.launch {
            try {
                val genres = movieGenreListUseCase.getGenres()
                internalGenresLiveData.postValue(genres)

                val movies = moviesUseCase.getMovies("chicken run", 1).results
                internalMoviesLiveData.postValue(movies)

                internalLoadingLiveData.postValue(genres.isEmpty() && movies.isEmpty())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}