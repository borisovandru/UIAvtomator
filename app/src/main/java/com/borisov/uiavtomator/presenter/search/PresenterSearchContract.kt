package com.borisov.uiavtomator.presenter.search

import com.borisov.uiavtomator.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
}