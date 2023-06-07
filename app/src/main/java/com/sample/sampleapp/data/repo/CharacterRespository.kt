package com.sample.sampleapp.data.repo

import com.sample.sampleapp.data.model.CharacterResponse
import com.sample.sampleapp.data.model.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CharacterRespository {
    suspend fun getData(): Flow<NetworkResult<CharacterResponse>>
}