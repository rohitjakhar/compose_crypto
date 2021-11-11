package com.rohitjakhar.cryptocoin.presentation.coin_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohitjakhar.cryptocoin.common.Constant.COIN_ID
import com.rohitjakhar.cryptocoin.common.Resource
import com.rohitjakhar.cryptocoin.domain.use_case.get_coins.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = mutableStateOf(CoinDetailsState())
    val state get() = _state

    init {
        savedStateHandle.get<String>(COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Empty -> {
                }
                is Resource.Error -> {

                    _state.value = CoinDetailsState(
                        error = result.message ?: "Unknown Error"
                    )
                }
                is Resource.Loading -> {

                    _state.value = CoinDetailsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailsState(
                        coins = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
