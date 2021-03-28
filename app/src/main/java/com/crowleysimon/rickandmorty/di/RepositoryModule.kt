package com.crowleysimon.rickandmorty.di

import com.crowleysimon.rickandmorty.data.repository.CharacterRepository
import com.crowleysimon.rickandmorty.data.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(repository: CharacterRepositoryImpl): CharacterRepository
}