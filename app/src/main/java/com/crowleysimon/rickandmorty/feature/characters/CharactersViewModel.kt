package com.crowleysimon.rickandmorty.feature.characters

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.crowleysimon.rickandmorty.data.repository.CharacterRepository
import com.crowleysimon.rickandmorty.data.response.CharacterResponse
import com.crowleysimon.rickandmorty.di.AssistedViewModelFactory
import com.crowleysimon.rickandmorty.di.hiltMavericksViewModelFactory
import com.crowleysimon.rickandmorty.feature.characters.model.CharacterItem
import com.crowleysimon.rickandmorty.feature.characters.model.CharactersState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class CharactersViewModel @AssistedInject constructor(
    @Assisted state: CharactersState,
    private val repository: CharacterRepository,
) : MavericksViewModel<CharactersState>(state) {

    private var characterList: List<CharacterResponse> = emptyList()

    fun fetchCharacters() {
        viewModelScope.launch {
            characterList = repository.getCharacters()
            setState { copy(characters = characterList.map { it.mapToItem() }) }
        }
    }


    private fun CharacterResponse.mapToItem() = CharacterItem(id, name, status, image)

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CharactersViewModel, CharactersState> {
        override fun create(state: CharactersState): CharactersViewModel
    }

    companion object :
        MavericksViewModelFactory<CharactersViewModel, CharactersState> by hiltMavericksViewModelFactory()

}