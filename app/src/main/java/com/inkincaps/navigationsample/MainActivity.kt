package com.inkincaps.navigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.inkincaps.navigationsample.MyFragment
import com.inkincaps.navigationsample.R


class MainActivity : AppCompatActivity() {

    private val fragmentOne by lazy {
        MyFragment()
    }

    private val fragmentTwo by lazy {
        NavHostFragment.create(R.navigation.form)
    }

    fun navigateToBoom() {
        create.navController.navigate(R.id.action_myFragment_to_about)
    }

    fun navigateToUserProfile(bundle:Bundle){
        findNavController(R.id.container).navigate(
                R.id.action_myFragment_to_userProfile2,bundle)
    }

    val create by lazy {
        NavHostFragment.create(R.navigation.main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_layout)
        supportFragmentManager.beginTransaction().replace(R.id.container, create).commitNow()
    }

    fun exit() {
        super.onBackPressed()
    }

    override fun onBackPressed() {
        if(!create.navController.navigateUp()){
            if(create.navController.currentDestination?.id == create.navController.graph.startDestination){
                val fragment = create.childFragmentManager.fragments[0]
                if(fragment is MyFragment){
                    if(fragment.canWeGoBack()){
                        super.onBackPressed()
                    }
                }else{
                    TODO()
                }
            }
        }
    }
}
