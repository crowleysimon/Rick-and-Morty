package com.crowleysimon.rickandmorty.di

import com.crowleysimon.rickandmorty.data.repository.CharacterRepository
import com.crowleysimon.rickandmorty.data.repository.CharacterRepositoryImpl
import com.crowleysimon.rickandmorty.remote.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String = "https://rickandmortyapi.com/api/"

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val timeout = 50L
        return OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    fun provideRetrofit(httpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    fun provideCharacterService(retrofit: Retrofit) = retrofit.create(CharacterService::class.java)

    @Provides
    fun provideCharacterRepository(characterService: CharacterService): CharacterRepository {
        return CharacterRepositoryImpl(characterService)
    }

}