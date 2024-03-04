package com.test.quizztimetest.views

import android.os.Bundle
import android.view.View
import androidx.navigation.NavGraph
import com.h2appi.quizztimetest.databinding.BaseLayoutBinding


class MainActivity() : BaseActivity() {

    override lateinit var binding: BaseLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val navController = navHostFragment.navController
        val navGraph: NavGraph = navInflater.inflate(com.h2appi.quizztimetest.R.navigation.nav_base)
        navController.graph = navGraph


        fb()
    }


    fun fb() {
        binding.fbM.setOnClickListener {
            navHostFragment.navController
                .navigate(com.h2appi.quizztimetest.R.id.homeQuizFragment)

        }
    }

    fun showFbButton() {
        binding.fbM.visibility = View.VISIBLE
    }

    fun hideFbButton() {
        binding.fbM.visibility = View.GONE
    }


}