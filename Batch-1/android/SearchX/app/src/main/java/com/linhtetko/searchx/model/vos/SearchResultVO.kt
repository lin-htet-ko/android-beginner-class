package com.linhtetko.searchx.model.vos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResultVO(
    @Json(name = "webformatURL")
    val img: String,
    @Json(name = "tags")
    val keywords: String
)
/*
{
    "imageURL": "https://www.google.com/img.png",
    "tags": "Beauty, Burma, Siam"
}
 */