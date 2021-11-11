package com.rohitjakhar.cryptocoin.domain.use_case.get_coins

import com.rohitjakhar.cryptocoin.common.Resource
import com.rohitjakhar.cryptocoin.data.remote.dto.toCoinDetails
import com.rohitjakhar.cryptocoin.domain.model.CoinDetails
import com.rohitjakhar.cryptocoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success(data = coin))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown"))
        }
    }
}
