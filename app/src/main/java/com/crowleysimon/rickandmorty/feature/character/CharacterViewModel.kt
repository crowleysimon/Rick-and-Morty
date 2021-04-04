package com.crowleysimon.rickandmorty.feature.character

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.crowleysimon.rickandmorty.data.repository.CharacterRepository
import com.crowleysimon.rickandmorty.data.response.CharacterResponse
import com.crowleysimon.rickandmorty.di.AssistedViewModelFactory
import com.crowleysimon.rickandmorty.di.hiltMavericksViewModelFactory
import com.crowleysimon.rickandmorty.feature.character.model.CharacterState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class CharacterViewModel @AssistedInject constructor(
    @Assisted state: CharacterState,
    private val repository: CharacterRepository,
) : MavericksViewModel<CharacterState>(state) {


    fun fetchCharacter(id: Int) {
        viewModelScope.launch {
            val char = repository.getCharacter(id)
            setState { copy(isLoading = false, character = char) }
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CharacterViewModel, CharacterState> {
        override fun create(state: CharacterState): CharacterViewModel
    }

    companion object :
        MavericksViewModelFactory<CharacterViewModel, CharacterState> by hiltMavericksViewModelFactory()

}