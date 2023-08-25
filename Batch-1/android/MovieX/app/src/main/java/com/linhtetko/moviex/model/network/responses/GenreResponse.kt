package com.linhtetko.moviex.model.network.responses

import com.linhtetko.moviex.model.vos.GenreVO
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreResponse(
    val genres: List<GenreVO>? = listOf()
)
