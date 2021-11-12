package com.rohitjakhar.cryptocoin.presentation.person_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohitjakhar.cryptocoin.common.Constant.PERSON_ID
import com.rohitjakhar.cryptocoin.common.Resource
import com.rohitjakhar.cryptocoin.domain.use_case.person_detail.GetPersonDetailUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(
    private val personDetailUserCase: GetPersonDetailUserCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = mutableStateOf(PersonDetailState())
    val state get() = _state

    init {
        savedStateHandle.get<String>(PERSON_ID)?.let {
            getPersonDetail(it)
        }
    }

    fun getPersonDetail(personId: String) {
        personDetailUserCase(personId).onEach {
            when (it) {
                is Resource.Empty -> {
                    _state.value = PersonDetailState(
                        personDetails = null
                    )
                }
                is Resource.Error -> {
                    _state.value = PersonDetailState(
                        error = it.message ?: "Unknown Error"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PersonDetailState(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _state.value = PersonDetailState(
                        personDetails = it.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
