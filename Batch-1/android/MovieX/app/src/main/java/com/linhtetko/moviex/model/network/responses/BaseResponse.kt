package com.linhtetko.moviex.model.network.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<T>
)