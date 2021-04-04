package com.crowleysimon.rickandmorty.feature.character

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.RoundedCornersTransformation
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.crowleysimon.rickandmorty.R
import com.crowleysimon.rickandmorty.common.viewBinding
import com.crowleysimon.rickandmorty.databinding.FragmentSecondBinding
import com.crowleysimon.rickandmorty.feature.character.model.CharacterState
import com.crowleysimon.rickandmorty.feature.characters.CharactersViewModel
import com.crowleysimon.rickandmorty.feature.characters.model.CharacterItem
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_second), MavericksView {

    private val binding: FragmentSecondBinding by viewBinding()
    private val viewModel: CharacterViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character: CharacterItem? = arguments?.getParcelable("character")

        character?.let {
            viewModel.fetchCharacter(it.id)
            binding.nameLabel.text = it.name
            binding.statusLabel.text = it.status
            binding.characterImage.load(character.image) {
                crossfade(true)
                crossfade(200)
                placeholder(R.color.placeholder)
                transformations(RoundedCornersTransformation(requireContext().resources.getDimension(
                    R.dimen.corner_radius)))
            }
        }
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            binding.progressBar.isVisible = state.isLoading
            if (state.character != null) {
                binding.textView.text = state.character.species
            }
        }
    }
}