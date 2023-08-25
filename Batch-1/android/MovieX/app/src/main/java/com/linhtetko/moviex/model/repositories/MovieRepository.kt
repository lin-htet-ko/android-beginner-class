package com.linhtetko.moviex.model.repositories

import com.linhtetko.moviex.model.vos.GenreVO
import com.linhtetko.moviex.model.vos.MovieVO
import com.linhtetko.moviex.model.vos.PeopleVO
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getGenres(): List<GenreVO>?

    suspend fun getPopularMovies(): Flow<List<MovieVO>>

    suspend fun getTopRatedMovies(): Flow<List<MovieVO>>

    suspend fun getUpComingMovies(): Flow<List<MovieVO>>

    suspend fun searchMovies(keyword: String): Flow<List<MovieVO>>

    suspend fun getPopularPeople(timeWindow: String): Flow<List<PeopleVO>>
}