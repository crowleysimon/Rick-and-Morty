package com.crowleysimon.rickandmorty.data.response

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CharactersResponse(
    val info: Info,
    val results: List<Character>,
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class Info(
        val count: Int,
        val next: String?,
        val pages: Int,
        val prev: String?,
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class Character(
        val created: String,
        val episode: List<String>,
        val gender: String,
        val id: Int,
        val image: String,
        val location: Location,
        val name: String,
        val origin: Origin,
        val species: String,
        val status: String,
        val type: String,
        val url: String,
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Location(
            val name: String,
            val url: String,
        )

        @Keep
        @JsonClass(generateAdapter = true)
        data class Origin(
            val name: String,
            val url: String,
        )
    }
}