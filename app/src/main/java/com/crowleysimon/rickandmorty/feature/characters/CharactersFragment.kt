package com.crowleysimon.rickandmorty.feature.characters

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.crowleysimon.rickandmorty.R
import com.crowleysimon.rickandmorty.common.viewBinding
import com.crowleysimon.rickandmorty.databinding.FragmentFirstBinding
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_first), MavericksView {

    private val binding: FragmentFirstBinding by viewBinding()
    private val viewModel: CharactersViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchCharacters()
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            binding.charactersListView.adapter = GroupieAdapter().apply { update(state.characters) }
        }
    }
}