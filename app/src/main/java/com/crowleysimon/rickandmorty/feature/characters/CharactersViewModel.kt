package com.crowleysimon.rickandmorty.feature.characters

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.crowleysimon.rickandmorty.data.repository.CharacterRepository
import com.crowleysimon.rickandmorty.data.response.CharactersResponse.Character
import com.crowleysimon.rickandmorty.di.AssistedViewModelFactory
import com.crowleysimon.rickandmorty.di.hiltMavericksViewModelFactory
import com.crowleysimon.rickandmorty.feature.characters.model.CharacterItem
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class CharactersViewModel @AssistedInject constructor(
    @Assisted state: CharactersState,
    private val repository: CharacterRepository,
) : MavericksViewModel<CharactersState>(state) {

    fun fetchCharacters() {
        viewModelScope.launch {
            val characters = repository.getCharacters()
            setState { copy(characters = characters.map { it.mapToItem() }) }
        }
    }


    fun Character.mapToItem() = CharacterItem(id, name, status, image)

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CharactersViewModel, CharactersState> {
        override fun create(state: CharactersState): CharactersViewModel
    }

    companion object :
        MavericksViewModelFactory<CharactersViewModel, CharactersState> by hiltMavericksViewModelFactory()

}