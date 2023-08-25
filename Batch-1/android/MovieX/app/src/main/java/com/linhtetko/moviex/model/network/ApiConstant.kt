package com.linhtetko.moviex.network

object ApiConstant {

    const val BASE_URL = "https://api.themoviedb.org"
    const val API_KEY = "2fc452377fa3b7abbe9a5b7a13f72491"
    private const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZmM0NTIzNzdmYTNiN2FiYmU5YTViN2ExM2Y3MjQ5MSIsInN1YiI6IjYyY2VjOTRlZDRjYzhlMDA0ZTI4MDVhNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.PzAjQ45nm4dyuJdsRMAyA9yJdtwZ54i7P4G8xJmYV2g"

    const val HEADER_AUTH = "Authorization: Bearer $TOKEN"
    const val QUERY_API_KEY = "api_key"
    const val QUERY_SEARCH = "query"
    const val PATH_TRENDING_PEOPLE = "time_window"

    const val GET_POPULAR_MOVIES = "/3/movie/popular"
    const val GET_TOP_RATED_MOVIES = "/3/movie/top_rated"
    const val GET_UP_COMING_MOVIES = "/3/movie/upcoming"
    const val GET_SEARCH_MOVIES = "/3/search/movie"
    const val GET_POPULAR_PEOPLE = "/3/trending/person/{$PATH_TRENDING_PEOPLE}"
}