package com.linhtetko.searchx.model.remote.api

import com.linhtetko.searchx.model.remote.response.SearchResultResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api")
    fun searchImage(
        @Query("key") key: String,
        @Query("q") keyword: String
    ): Call<SearchResultResponse>

    companion object {

        val INSTANCE =
            Retrofit.Builder().baseUrl("https://pixabay.com")
                .addConverterFactory(MoshiConverterFactory.create()).build()
                .create(PixabayApi::class.java)
    }
}