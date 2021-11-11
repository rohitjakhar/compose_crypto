package com.rohitjakhar.cryptocoin.domain.use_case.get_coin

import com.rohitjakhar.cryptocoin.common.Resource
import com.rohitjakhar.cryptocoin.data.remote.dto.toCoin
import com.rohitjakhar.cryptocoin.domain.model.Coin
import com.rohitjakhar.cryptocoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(data = coins))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown"))
        }
    }
}
