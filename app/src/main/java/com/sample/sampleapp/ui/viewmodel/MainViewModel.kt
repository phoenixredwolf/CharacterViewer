package com.sample.sampleapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.sampleapp.data.model.CharacterResponse
import com.sample.sampleapp.data.model.NetworkResult
import com.sample.sampleapp.data.repo.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: CharacterRepository): ViewModel() {

    private var _characters = MutableLiveData<NetworkResult<CharacterResponse>>()
    val characters: LiveData<NetworkResult<CharacterResponse>> = _characters

    var characterDetails = MutableLiveData<CharacterResponse.RelatedTopic>()
    var characterUrl = ""

    init {
        getData()
    }

    @VisibleForTesting
    private fun getData() {
        viewModelScope.launch {
            repo.getData().collect {
                _characters.postValue(it)
            }
        }
    }

}