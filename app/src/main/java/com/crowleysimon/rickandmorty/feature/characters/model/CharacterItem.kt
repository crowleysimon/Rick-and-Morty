package com.crowleysimon.rickandmorty.feature.characters.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterItem(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
) : Parcelable