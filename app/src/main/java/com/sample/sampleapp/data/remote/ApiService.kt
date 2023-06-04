package com.sample.sampleapp.data.remote

import com.sample.sampleapp.BuildConfig
import com.sample.sampleapp.data.model.CharacterResponse
import retrofit2.http.GET

interface ApiService {

    @GET(BuildConfig.SEARCH_TERM)
    suspend fun getData(): CharacterResponse
}