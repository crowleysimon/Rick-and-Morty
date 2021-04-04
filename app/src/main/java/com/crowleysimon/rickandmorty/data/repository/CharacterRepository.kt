package com.crowleysimon.rickandmorty.data.repository

import com.crowleysimon.rickandmorty.data.response.CharacterResponse
import com.crowleysimon.rickandmorty.remote.CharacterService
import javax.inject.Inject

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterResponse>
    suspend fun getCharacter(id: Int): CharacterResponse
}

class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService,
) : CharacterRepository {

    override suspend fun getCharacters(): List<CharacterResponse> =
        characterService.getCharacters().results

    override suspend fun getCharacter(id: Int): CharacterResponse =
        characterService.getCharacter(id)

}