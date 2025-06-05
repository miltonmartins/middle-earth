package com.martins.milton.middle.earth.domain.entity

data class Character(
    val id: String,
    val name: String,
    val race: String,
    val wikiUrl: String?
)