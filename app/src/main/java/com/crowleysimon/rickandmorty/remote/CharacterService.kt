package com.crowleysimon.rickandmorty.remote

import com.crowleysimon.rickandmorty.data.response.CharacterResponse
import com.crowleysimon.rickandmorty.data.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterResponse

}