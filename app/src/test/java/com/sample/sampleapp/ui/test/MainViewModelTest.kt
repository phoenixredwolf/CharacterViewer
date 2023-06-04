package com.sample.sampleapp.ui.test

import com.sample.sampleapp.data.model.CharacterResponse
import com.sample.sampleapp.data.repo.CharacterRepository
import com.sample.sampleapp.ui.viewmodel.MainViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    private val characters = mock<CharacterResponse.RelatedTopic>()
    private val repo = mock<CharacterRepository>()

    @Before
    fun setup() {
        viewModel = MainViewModel(repo)
    }

    @Test
    fun `Ensure Loading State returned`() = runBlocking {

    }

}