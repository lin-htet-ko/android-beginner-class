package com.linhtetko.moviex.network.api

import com.linhtetko.moviex.network.ApiConstant.GET_POPULAR_MOVIES
import com.linhtetko.moviex.network.ApiConstant.GET_POPULAR_PEOPLE
import com.linhtetko.moviex.network.ApiConstant.GET_SEARCH_MOVIES
import com.linhtetko.moviex.network.ApiConstant.GET_TOP_RATED_MOVIES
import com.linhtetko.moviex.network.ApiConstant.GET_UP_COMING_MOVIES
import com.linhtetko.moviex.network.ApiConstant.PATH_TRENDING_PEOPLE
import com.linhtetko.moviex.network.ApiConstant.QUERY_SEARCH
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbApi {

    @GET(GET_POPULAR_MOVIES)

    fun getPopularMovies(@Header("") )

    @GET(GET_TOP_RATED_MOVIES)
    fun getTopRatedMovies()

    @GET(GET_UP_COMING_MOVIES)
    fun getUpComingMovies()

    @GET(GET_SEARCH_MOVIES)
    fun searchMovies(@Query(QUERY_SEARCH) query: String)

    @GET(GET_POPULAR_PEOPLE)
    fun getPopularPeople(@Path(PATH_TRENDING_PEOPLE) timeWindow: String)
}