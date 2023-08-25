package com.linhtetko.moviex.model.di

import com.linhtetko.moviex.model.network.ApiConstant
import com.linhtetko.moviex.model.network.api.MovieDbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface ApiModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieDbApi {
        return Retrofit.Builder()
            .baseUrl(ApiConstant.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieDbApi::class.java)
    }
}