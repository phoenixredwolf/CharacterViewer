package com.sample.sampleapp.repo.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.sample.sampleapp.data.model.CharacterResponse
import com.sample.sampleapp.data.model.NetworkResult
import com.sample.sampleapp.data.remote.ApiService
import com.sample.sampleapp.data.repo.CharacterRepositoryImpl
import com.sample.sampleapp.utility.MOCK_DATA
import com.sample.sampleapp.utility.MOCK_JSON
import com.sample.sampleapp.utility.mockCharacter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RepositoryTest {

    private val response = MutableLiveData<NetworkResult<CharacterResponse>>()
    private val mockWebServer = MockWebServer()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var retrofit: Retrofit
    @Mock
    private lateinit var moshi: Moshi

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        mockWebServer.start(8080)
        moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .baseUrl(mockWebServer.url("http://localhost:8080").toString())
            .build()
    }

    @Test
    fun `Test api success response`() = runTest {
        mockWebServer.enqueue(MockResponse().setBody("$MOCK_JSON").setResponseCode(200))
        val service = retrofit.create(ApiService::class.java)
        val result = service.getData()
        Assert.assertEquals(mockCharacter, result)
    }

    @Test
    fun `Test api failure response`() = runTest {
        val service = retrofit.create(ApiService::class.java)
        mockWebServer.enqueue(MockResponse().setResponseCode(404))
        try {
            val result = service.getData()
            assert(false)
        } catch (e: Exception) {
            assert(true)
        }
    }

    @Test
    fun `Test Repo Success Response`() = runTest {
        mockWebServer.enqueue(MockResponse().setBody(MOCK_DATA).setResponseCode(200))
        val expectedResponse = MutableLiveData<NetworkResult<CharacterResponse>>()
        expectedResponse.value = NetworkResult.Success(mockCharacter)
        val service = retrofit.create(ApiService::class.java)
        val repo = CharacterRepositoryImpl(service)
        repo.getData().collect {
            response.value = it
        }
        Assert.assertEquals(expectedResponse.value, response.value)
    }

    @Test
    fun `Test Repo Error Response`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(500))
        val expectedResponse = MutableLiveData<NetworkResult<CharacterResponse>>()
        expectedResponse.value = NetworkResult.Error(msg = "HTTP 500 Server Error")
        val service = retrofit.create(ApiService::class.java)
        val repo = CharacterRepositoryImpl(service)
        repo.getData().collect {
            response.value = it
        }
        Assert.assertEquals(expectedResponse.value, response.value)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }
}