package com.linhtetko.moviex.model.repositories

import com.linhtetko.moviex.model.network.api.MovieDbApi
import com.linhtetko.moviex.model.vos.GenreVO
import com.linhtetko.moviex.model.vos.MovieVO
import com.linhtetko.moviex.model.vos.PeopleVO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDbApi: MovieDbApi
) : MovieRepository {

    override suspend fun getGenres(): List<GenreVO>? {
        return movieDbApi.getGenres()?.genres
    }

    override suspend fun getPopularMovies(): Flow<List<MovieVO>> {
        val response = movieDbApi.getPopularMovies()
        return flow {
            emit(response?.results ?: listOf())
        }
    }

    override suspend fun getTopRatedMovies(): Flow<List<MovieVO>> {
        return flow {
            movieDbApi.getTopRatedMovies()?.results
        }
    }

    override suspend fun getUpComingMovies(): Flow<List<MovieVO>> {
        return flow {
            movieDbApi.getUpComingMovies()?.results
        }
    }

    override suspend fun searchMovies(keyword: String): Flow<List<MovieVO>> {
        return flow {
            movieDbApi.searchMovies(keyword)?.results
        }
    }

    override suspend fun getPopularPeople(timeWindow: String): Flow<List<PeopleVO>> {
        return flow {
            movieDbApi.getPopularPeople(timeWindow)?.results
        }
    }
}