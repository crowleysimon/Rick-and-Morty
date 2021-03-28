package com.crowleysimon.rickandmorty.di

import com.crowleysimon.rickandmorty.feature.characters.CharactersViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    fun CharactersViewModelFactory(factory: CharactersViewModel.Factory): AssistedViewModelFactory<*, *>

}