package com.crowleysimon.rickandmorty.data.repository

import com.crowleysimon.rickandmorty.data.response.CharactersResponse.Character
import com.crowleysimon.rickandmorty.remote.CharacterService
import javax.inject.Inject

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}

class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService,
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return characterService.getCharacters().results
    }

}