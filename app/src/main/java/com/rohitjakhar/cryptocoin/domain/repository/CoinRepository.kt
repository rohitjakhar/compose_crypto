package com.rohitjakhar.cryptocoin.domain.repository

import com.rohitjakhar.cryptocoin.data.remote.dto.CoinDetailsDto
import com.rohitjakhar.cryptocoin.data.remote.dto.CoinDto
import com.rohitjakhar.cryptocoin.data.remote.dto.PersonDetailDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto

    suspend fun getPersonDetails(personId: String): PersonDetailDto
}
