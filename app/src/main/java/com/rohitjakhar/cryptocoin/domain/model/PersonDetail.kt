package com.rohitjakhar.cryptocoin.domain.model

import com.rohitjakhar.cryptocoin.data.remote.dto.PersonDetailDto

data class PersonDetail(
    val id: String,
    val name: String,
    val description: String,
    val githubLink: String,
    val linkedinLink: String,
    val mediumLink: String,
    val twitterLink: String,
    val position: List<PersonDetailDto.Position>
)
