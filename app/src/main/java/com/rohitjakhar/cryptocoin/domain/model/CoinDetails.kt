package com.rohitjakhar.cryptocoin.domain.model

import com.rohitjakhar.cryptocoin.data.remote.dto.CoinDetailsDto

data class CoinDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<CoinDetailsDto.TeamMember>
)
