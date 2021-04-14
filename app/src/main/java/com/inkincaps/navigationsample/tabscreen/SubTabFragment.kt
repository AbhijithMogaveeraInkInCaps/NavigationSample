package com.inkincaps.navigationsample.tabscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.inkincaps.navigationsample.MainActivity
import com.inkincaps.navigationsample.R
import com.google.android.material.tabs.TabLayoutMediator

class SubTabFragment : Fragment() {
    private lateinit var tabLayoutMediator: TabLayoutMediator
    private val findViewById by lazy { view?.findViewById<ViewPager2>(R.id.search_viewpager) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchViewPagerAdapter = SubFragmentAdapter(childFragmentManager, viewLifecycleOwner.lifecycle, SUB_FRAGMENT_ITEM_LIST.size)
        (view.findViewById(R.id.search_viewpager) as ViewPager2).adapter = searchViewPagerAdapter
        tabLayoutMediator = TabLayoutMediator(view.findViewById(R.id.tabl), view.findViewById(R.id.search_viewpager)) { tab, position ->
            tab.text = SUB_FRAGMENT_ITEM_LIST[position]
        }
        tabLayoutMediator.attach()
    }

    fun onBackPressed() {
        if(findViewById?.currentItem==0){
            (activity as MainActivity).exit()
        }
        findViewById?.currentItem = 0
    }
}