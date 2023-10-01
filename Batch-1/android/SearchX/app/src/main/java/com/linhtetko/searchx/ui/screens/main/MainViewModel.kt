package com.linhtetko.searchx.ui.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.linhtetko.searchx.model.repositories.SearchResultRepository
import com.linhtetko.searchx.model.vos.SearchResultVO

class MainViewModel : ViewModel() {

    val searchResult = MutableLiveData<List<SearchResultVO>>()
    val error = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    private val searchRepository = SearchResultRepository

    fun searchImage(keyword: String) {
        loading.value = true
        searchRepository.search(
            keyword = keyword,
            onSuccess = {
                searchResult.value = it
                loading.value = false
            },
            onFailure = {
                error.value = it
                loading.value = false
            }
        )
    }
}