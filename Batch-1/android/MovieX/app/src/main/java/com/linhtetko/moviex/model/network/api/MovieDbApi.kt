package com.linhtetko.moviex.model.network.api

import com.linhtetko.moviex.model.network.ApiConstant.GET_GENRES
import com.linhtetko.moviex.model.network.ApiConstant.GET_POPULAR_MOVIES
import com.linhtetko.moviex.model.network.ApiConstant.GET_POPULAR_PEOPLE
import com.linhtetko.moviex.model.network.ApiConstant.GET_SEARCH_MOVIES
import com.linhtetko.moviex.model.network.ApiConstant.GET_TOP_RATED_MOVIES
import com.linhtetko.moviex.model.network.ApiConstant.GET_UP_COMING_MOVIES
import com.linhtetko.moviex.model.network.ApiConstant.HEADER_AUTH
import com.linhtetko.moviex.model.network.ApiConstant.PATH_TRENDING_PEOPLE
import com.linhtetko.moviex.model.network.ApiConstant.QUERY_SEARCH
import com.linhtetko.moviex.model.network.responses.BaseResponse
import com.linhtetko.moviex.model.network.responses.GenreResponse
import com.linhtetko.moviex.model.vos.MovieVO
import com.linhtetko.moviex.model.vos.PeopleVO
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbApi {

    @GET(GET_GENRES)
    @Headers(HEADER_AUTH)
    suspend fun getGenres(): GenreResponse?

    @GET(GET_POPULAR_MOVIES)
    @Headers(HEADER_AUTH)
    suspend fun getPopularMovies(): BaseResponse<MovieVO>?

    @GET(GET_TOP_RATED_MOVIES)
    @Headers(HEADER_AUTH)
    suspend fun getTopRatedMovies(): BaseResponse<MovieVO>?

    @GET(GET_UP_COMING_MOVIES)
    @Headers(HEADER_AUTH)
    suspend fun getUpComingMovies(): BaseResponse<MovieVO>?

    @GET(GET_SEARCH_MOVIES)
    @Headers(HEADER_AUTH)
    suspend fun searchMovies(@Query(QUERY_SEARCH) query: String): BaseResponse<MovieVO>?

    @GET(GET_POPULAR_PEOPLE)
    @Headers(HEADER_AUTH)
    suspend fun getPopularPeople(@Path(PATH_TRENDING_PEOPLE) timeWindow: String): BaseResponse<PeopleVO>?
}