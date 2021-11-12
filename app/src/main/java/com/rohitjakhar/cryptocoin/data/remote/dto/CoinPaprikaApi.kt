package com.rohitjakhar.cryptocoin.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto

    @GET("v1/people/{personId}")
    suspend fun getPersonDetail(@Path("personId") personId: String): PersonDetailDto
}
