package com.borisov.uiavtomator.repository

import retrofit2.Response
import com.borisov.uiavtomator.model.SearchResponse
import com.borisov.uiavtomator.presenter.RepositoryContract

internal class FakeGitHubRepository : RepositoryContract {

    override fun searchGithub(
        query: String,
        callback: RepositoryCallback
    ) {
        callback.handleGitHubResponse(Response.success(SearchResponse(42, listOf())))
    }
}