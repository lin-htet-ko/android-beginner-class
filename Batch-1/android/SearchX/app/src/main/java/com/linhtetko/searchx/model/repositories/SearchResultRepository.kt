package com.linhtetko.searchx.model.repositories

import com.linhtetko.searchx.model.remote.api.PixabayApi
import com.linhtetko.searchx.model.remote.response.SearchResultResponse
import com.linhtetko.searchx.model.vos.SearchResultVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object SearchResultRepository {

    fun search(
        keyword: String,
        onSuccess: (List<SearchResultVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        PixabayApi.INSTANCE.searchImage(
            key = "22156654-c38411b4b1732e871561f9a50",
            keyword = keyword
        ).enqueue(object : Callback<SearchResultResponse> {
            override fun onResponse(
                call: Call<SearchResultResponse>,
                response: Response<SearchResultResponse>
            ) {
                if (response.isSuccessful) {
                    val hits = response.body()?.hits ?: emptyList()
                    onSuccess(hits)
                }
            }

            override fun onFailure(call: Call<SearchResultResponse>, t: Throwable) {
                onFailure(t.localizedMessage ?: "Something Wrong")
            }
        })
    }
}