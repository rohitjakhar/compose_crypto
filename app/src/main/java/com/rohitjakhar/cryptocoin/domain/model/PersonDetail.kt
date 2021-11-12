package com.rohitjakhar.cryptocoin.domain.model

import com.rohitjakhar.cryptocoin.data.remote.dto.PersonDetailDto

data class PersonDetail(
    val id: String,
    val name: String,
    val description: String? = null,
    val githubLink: String? = null,
    val linkedinLink: String? = null,
    val mediumLink: String? = null,
    val twitterLink: String? = null,
    val position: List<PersonDetailDto.Position>
)
