package com.borisov.uiavtomator.repository

import retrofit2.Response
import com.borisov.uiavtomator.model.SearchResponse

interface RepositoryCallback {
    fun handleGitHubResponse(response: Response<SearchResponse?>?)
    fun handleGitHubError()
}
