package com.crowleysimon.rickandmorty.feature.characters.model

import com.airbnb.mvrx.MavericksState
import com.crowleysimon.rickandmorty.feature.characters.model.CharacterAdapterItem
import com.crowleysimon.rickandmorty.feature.characters.model.CharacterItem

data class CharactersState(
    val characters: List<CharacterItem> = emptyList(),
) : MavericksState