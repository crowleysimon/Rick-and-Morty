package com.crowleysimon.rickandmorty.data.response

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CharactersResponse(
    val info: Info,
    val results: List<CharacterResponse>,
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class Info(
        val count: Int,
        val next: String?,
        val pages: Int,
        val prev: String?,
    )
}