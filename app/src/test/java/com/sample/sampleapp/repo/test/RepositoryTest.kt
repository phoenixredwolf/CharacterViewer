package com.sample.sampleapp.repo.test

import com.sample.sampleapp.data.remote.ApiService
import com.sample.sampleapp.data.repo.CharacterRepository
import org.junit.Test
import org.mockito.Mockito.mock

class RepositoryTest {

    private val apiService = mock<ApiService>()

    val repo = CharacterRepository(apiService)

    @Test
    fun `Test flow success response`() {
        
    }
}