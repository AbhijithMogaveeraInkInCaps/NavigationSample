package com.inkincaps.navigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.inkincaps.navigationsample.tabscreen.MainTabFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

data class Data(val navId: Int, val navHostFragment: NavHostFragment)

class MyFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var list: List<Fragment>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.activity_main,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView = view.findViewById(R.id.bottom_nav)
        viewPager = view.findViewById(R.id.vp)

        list = listOf(
                BlankFragment(),
                MainTabFragment(),
                BlankFragment(),
                BlankFragment(),
                BlankFragment(),
        )

        val value = object : FragmentStateAdapter(childFragmentManager, lifecycle) {

            override fun getItemCount(): Int {
                return list.size
            }

            override fun createFragment(position: Int): Fragment {
                return list[position]
            }
        }

        viewPager.apply {
            adapter = value
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    Toast.makeText(requireContext(), "$position", Toast.LENGTH_SHORT).show()
                }
            })

        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    viewPager.currentItem = 0
                }
                R.id.list -> {
                    viewPager.currentItem = 1
                }
                R.id.form -> {
                    viewPager.currentItem = 2
                }
                R.id.search->{
                    viewPager.currentItem = 3
                }
                R.id.message->{
                    viewPager.currentItem = 4
                }
            }
            lastItemId = it.itemId
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var lastItemId:Int=0

    fun canWeGoBack():Boolean{
        val x = bottomNavigationView.selectedItemId==R.id.home
        if(!x) {
            bottomNavigationView.selectedItemId = R.id.home
        }
        return x
    }
}
