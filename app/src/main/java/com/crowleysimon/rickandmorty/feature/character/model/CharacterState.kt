package com.crowleysimon.rickandmorty.feature.character.model

import com.airbnb.mvrx.MavericksState
import com.crowleysimon.rickandmorty.data.response.CharacterResponse

data class CharacterState(
    val isLoading: Boolean = true,
    val character: CharacterResponse? = null,
) : MavericksState