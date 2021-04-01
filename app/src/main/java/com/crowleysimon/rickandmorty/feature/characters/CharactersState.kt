package com.crowleysimon.rickandmorty.feature.characters

import com.airbnb.mvrx.MavericksState
import com.crowleysimon.rickandmorty.data.response.CharactersResponse.Character
import com.crowleysimon.rickandmorty.feature.characters.model.CharacterItem

data class CharactersState(
    val characters: List<CharacterItem> = emptyList(),
) : MavericksState