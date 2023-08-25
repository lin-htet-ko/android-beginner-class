package com.linhtetko.moviex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linhtetko.moviex.model.repositories.MovieRepository
import com.linhtetko.moviex.model.vos.MovieVO
import com.linhtetko.moviex.model.vos.PeopleVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<MovieVO>>()
    val popularMovies: LiveData<List<MovieVO>> = _popularMovies

    private val _searchedMovies = MutableLiveData<List<MovieVO>>()
    val searchedMovies: LiveData<List<MovieVO>> = _searchedMovies

    private val _topRatedMovies = MutableLiveData<List<MovieVO>>()
    val topRatedMovies: LiveData<List<MovieVO>> = _topRatedMovies

    private val _upComingMovies = MutableLiveData<List<MovieVO>>()
    val upComingMovies: LiveData<List<MovieVO>> = _upComingMovies

    private val _popularPeopleMovies = MutableLiveData<List<PeopleVO>>()
    val popularPeopleMovies: LiveData<List<MovieVO>> = _upComingMovies

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    fun getPopularMovies() {
        viewModelScope.launch {
            movieRepository.getPopularMovies()
                .flowOn(Dispatchers.IO)
                .catch {
                    _error.postValue(it.localizedMessage)
                }.collect {
                    _popularMovies.postValue(it)
                }
        }
    }

    fun getTopRated() {
        viewModelScope.launch {
            movieRepository.getTopRatedMovies()
                .flowOn(Dispatchers.IO)
                .catch {
                    _error.postValue(it.localizedMessage)
                }
                .collect {
                    _topRatedMovies.postValue(it)
                }
        }

    }

    fun getUpComingMovie() {
        viewModelScope.launch {
            movieRepository.getUpComingMovies()
                .flowOn(Dispatchers.IO)
                .catch {
                    _error.postValue(it.localizedMessage)
                }
                .collect {
                    _upComingMovies.postValue(it)
                }
        }
    }

    fun getPopularPeople() {
        viewModelScope.launch {
            movieRepository.getPopularPeople("day")
                .flowOn(Dispatchers.IO)
                .catch {
                    _error.postValue(it.localizedMessage)
                }
                .collect {
                    _popularPeopleMovies.postValue(it)
                }
        }
    }

    fun searchMovie(keyword: String) {
        viewModelScope.launch {
            movieRepository.searchMovies(keyword)
                .flowOn(Dispatchers.IO)
                .catch {
                    _error.postValue(it.localizedMessage)
                }.collect {
                    if (keyword.isEmpty())
                        _searchedMovies.postValue(emptyList())
                    else
                        _searchedMovies.postValue(it)
                }
        }
    }
}