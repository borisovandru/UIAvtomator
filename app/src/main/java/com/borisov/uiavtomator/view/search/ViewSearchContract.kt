package com.borisov.uiavtomator.view.search

import com.borisov.uiavtomator.model.SearchResult
import com.borisov.uiavtomator.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}