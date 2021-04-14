package com.inkincaps.navigationsample.tabscreen

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.inkincaps.navigationsample.BlankFragment
import kotlin.random.Random

class MainFragmentAdapter(val mainTabFragment: MainTabFragment, fragmentManager: FragmentManager, lifecycle: Lifecycle, val size: Int) : FragmentStateAdapter(fragmentManager, lifecycle) {

    init {
        Log.e("KOTLIN","SearchViewPagerAdapter ${Random.nextInt()}")
    }

    private lateinit var subTabFragment: SubTabFragment
    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 1 ) {
            subTabFragment = SubTabFragment()
            return subTabFragment
        }
        return BlankFragment()
    }

    fun onBackPressed():Boolean {
        return if (this::subTabFragment.isInitialized) {
            subTabFragment.onBackPressed()
            true
        } else{
            return false
        }
    }
}

