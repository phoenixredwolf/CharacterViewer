package com.sample.sampleapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sample.sampleapp.data.model.CharacterResponse
import com.sample.sampleapp.data.model.NetworkResult
import com.sample.sampleapp.data.remote.ApiService
import com.sample.sampleapp.data.repo.CharacterRepositoryImpl
import com.sample.sampleapp.utility.mockCharacter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private val testCharacters = MutableLiveData<NetworkResult<CharacterResponse>>()
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Captor
    private lateinit var captor: ArgumentCaptor<NetworkResult<CharacterResponse>>

    @Mock
    private lateinit var observer: Observer<NetworkResult<CharacterResponse>>
    @Mock
    private lateinit var apiService: ApiService
    @Mock
    private lateinit var repo: CharacterRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Testing viewmodel success response`() = runTest(testDispatcher) {
        `when`(apiService.getData()).thenReturn(mockCharacter)
        repo = CharacterRepositoryImpl(apiService)
        viewModel = MainViewModel(repo)
        viewModel.characters.observeForever(observer)
        Mockito.verify(observer, Mockito.times(1)).onChanged(MockitoHelper.capture(captor))
        val values = captor.allValues
        testCharacters.value = NetworkResult.Success(mockCharacter)
        Assert.assertEquals(testCharacters.value, values.get(0))
    }


}

object MockitoHelper {
    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}