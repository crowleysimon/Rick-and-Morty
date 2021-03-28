package com.crowleysimon.rickandmorty.feature.characters

import com.airbnb.mvrx.MavericksState
import com.crowleysimon.rickandmorty.data.response.CharactersResponse.Character

data class CharactersState(
    val characters: List<Character> = emptyList(),
) : MavericksState