package com.linhtetko.searchx.model.remote.response


import com.linhtetko.searchx.model.vos.SearchResultVO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResultResponse(
    @Json(name = "hits")
    val hits: List<SearchResultVO>,
    @Json(name = "total")
    val total: Int,
    @Json(name = "totalHits")
    val totalHits: Int
)