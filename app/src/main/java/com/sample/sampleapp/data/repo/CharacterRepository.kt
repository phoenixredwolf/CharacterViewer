package com.sample.sampleapp.data.repo

import com.sample.sampleapp.data.model.NetworkResult
import com.sample.sampleapp.data.remote.ApiService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getData() = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getData()
        emit(NetworkResult.Success(response))
    }.catch { e ->
        emit(NetworkResult.Error(e.message ?: "Unknown Error" ))
    }
}