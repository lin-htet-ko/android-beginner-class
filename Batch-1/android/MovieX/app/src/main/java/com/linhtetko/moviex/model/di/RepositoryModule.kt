package com.linhtetko.moviex.model.di

import com.linhtetko.moviex.model.repositories.MovieRepository
import com.linhtetko.moviex.model.repositories.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindMovieRepo(impl: MovieRepositoryImpl): MovieRepository
}