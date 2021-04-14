package com.inkincaps.navigationsample.tabscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.inkincaps.navigationsample.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.inkincaps.navigationsample.tabscreen.MAIN_FRAGMENT_ITEM_LIST
import com.inkincaps.navigationsample.tabscreen.MainFragmentAdapter
import kotlin.random.Random

class MainTabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }


    init {
        Log.e("KOTLIN", "TabFragment ${Random.nextInt()}")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainFragmentAdapter: MainFragmentAdapter by lazy {
            MainFragmentAdapter(this, childFragmentManager, viewLifecycleOwner.lifecycle, MAIN_FRAGMENT_ITEM_LIST.size)
        }
        val findViewById by lazy { view.findViewById<ViewPager2>(R.id.search_viewpager) }

        val tb: TabLayout by lazy {
            view.findViewById(R.id.tabl) as TabLayout
        }
        (view.findViewById(R.id.search_viewpager) as ViewPager2).adapter = mainFragmentAdapter


        TabLayoutMediator(
                tb,
                view.findViewById(R.id.search_viewpager)
        ) { tab, position ->
            tab.text = MAIN_FRAGMENT_ITEM_LIST[position]
        }.attach()
        if (findViewById?.currentItem == 0)
            findViewById?.currentItem = 1

    }
}
