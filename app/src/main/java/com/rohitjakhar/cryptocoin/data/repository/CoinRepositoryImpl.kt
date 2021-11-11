package com.rohitjakhar.cryptocoin.data.repository

import com.rohitjakhar.cryptocoin.data.remote.dto.CoinDetailsDto
import com.rohitjakhar.cryptocoin.data.remote.dto.CoinDto
import com.rohitjakhar.cryptocoin.data.remote.dto.CoinPaprikaApi
import com.rohitjakhar.cryptocoin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}
