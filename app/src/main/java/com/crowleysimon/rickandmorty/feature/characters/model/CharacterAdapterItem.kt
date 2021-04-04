package com.crowleysimon.rickandmorty.feature.characters.model

import android.view.View
import coil.load
import coil.transform.RoundedCornersTransformation
import com.crowleysimon.rickandmorty.R
import com.crowleysimon.rickandmorty.databinding.ItemCharacterBinding
import com.xwray.groupie.viewbinding.BindableItem

data class CharacterAdapterItem(
    val character: CharacterItem,
    val onClick: (id: Int) -> Unit,
) : BindableItem<ItemCharacterBinding>() {

    override fun getId() = character.id.toLong()

    override fun bind(viewBinding: ItemCharacterBinding, position: Int) {
        with(viewBinding) {
            nameLabel.text = character.name
            statusLabel.text = character.status
            characterImage.load(character.image) {
                crossfade(true)
                crossfade(200)
                placeholder(R.color.placeholder)
                transformations(RoundedCornersTransformation(root.context.resources.getDimension(R.dimen.corner_radius)))
            }
            root.setOnClickListener { onClick(character.id) }
        }
    }

    override fun getLayout() = R.layout.item_character

    override fun initializeViewBinding(view: View) = ItemCharacterBinding.bind(view)
}