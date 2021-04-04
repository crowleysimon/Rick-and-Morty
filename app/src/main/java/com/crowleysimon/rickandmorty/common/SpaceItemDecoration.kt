package com.crowleysimon.rickandmorty.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.crowleysimon.rickandmorty.R
import com.crowleysimon.rickandmorty.common.SpaceItemDecoration.Orientation.HORIZONTAL
import com.crowleysimon.rickandmorty.common.SpaceItemDecoration.Orientation.VERTICAL

class SpaceItemDecoration(
    private val space: Int = 0,
    private val orientation: Orientation = VERTICAL,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        val distance = if (space == 0) {
            view.context.resources.getDimension(R.dimen.list_space).toInt()
        } else {
            space
        }

        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return

        when (orientation) {
            VERTICAL -> {
                outRect.top = distance

                if (position == state.itemCount - 1) outRect.bottom = outRect.top
            }
            HORIZONTAL -> {
                outRect.left = distance

                if (position == state.itemCount - 1) outRect.right = outRect.left
            }
        }
    }

    enum class Orientation {
        VERTICAL, HORIZONTAL
    }
}