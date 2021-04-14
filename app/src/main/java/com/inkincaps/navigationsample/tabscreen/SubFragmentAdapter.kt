package com.inkincaps.navigationsample.tabscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.inkincaps.navigationsample.listscreen.Leaderboard

class SubFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, val size: Int) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {

        return Leaderboard()
    }
}