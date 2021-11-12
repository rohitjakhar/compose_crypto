package com.rohitjakhar.cryptocoin.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.rohitjakhar.cryptocoin.domain.model.PersonDetail

data class PersonDetailDto(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("positions")
    val positions: List<Position>,
    @SerializedName("teams_count")
    val teamsCount: Int
) {
    data class Links(
        @SerializedName("github")
        val github: List<Github>? = null,
        @SerializedName("linkedin")
        val linkedin: List<Linkedin>? = null,
        @SerializedName("medium")
        val medium: List<Medium>? = null,
        @SerializedName("twitter")
        val twitter: List<Twitter>? = null
    ) {
        data class Github(
            @SerializedName("followers")
            val followers: Int,
            @SerializedName("url")
            val url: String
        )

        data class Linkedin(
            @SerializedName("url")
            val url: String
        )

        data class Medium(
            @SerializedName("followers")
            val followers: Int,
            @SerializedName("url")
            val url: String
        )

        data class Twitter(
            @SerializedName("followers")
            val followers: Int,
            @SerializedName("url")
            val url: String
        )
    }

    data class Position(
        @SerializedName("coin_id")
        val coinId: String,
        @SerializedName("coin_name")
        val coinName: String,
        @SerializedName("coin_symbol")
        val coinSymbol: String,
        @SerializedName("position")
        val position: String
    )
}

fun PersonDetailDto.toPersonDetail(): PersonDetail {
    return PersonDetail(
        id = id,
        name = name,
        description = description,
        githubLink = links.github?.first()?.url,
        linkedinLink = links.linkedin?.first()?.url,
        mediumLink = links.medium?.first()?.url,
        twitterLink = links.twitter?.first()?.url,
        position = positions
    )
}
