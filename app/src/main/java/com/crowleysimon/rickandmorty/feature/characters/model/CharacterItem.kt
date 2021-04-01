package com.crowleysimon.rickandmorty.feature.characters.model

import android.view.View
import coil.load
import com.crowleysimon.rickandmorty.R
import com.crowleysimon.rickandmorty.databinding.ItemCharacterBinding
import com.xwray.groupie.viewbinding.BindableItem

data class CharacterItem(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
) : BindableItem<ItemCharacterBinding>() {

    override fun getId() = id.toLong()

    override fun bind(viewBinding: ItemCharacterBinding, position: Int) {
        with(viewBinding) {
            nameLabel.text = name
            statusLabel.text = status
            characterImage.load(image)
        }
    }

    override fun getLayout() = R.layout.item_character

    override fun initializeViewBinding(view: View) = ItemCharacterBinding.bind(view)
}