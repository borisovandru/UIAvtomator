package com.borisov.uiavtomator.presenter

import com.borisov.uiavtomator.repository.RepositoryCallback

internal interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )
}