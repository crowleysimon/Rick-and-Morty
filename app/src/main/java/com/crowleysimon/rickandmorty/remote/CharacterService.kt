package com.crowleysimon.rickandmorty.remote

import com.crowleysimon.rickandmorty.data.response.CharactersResponse
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}