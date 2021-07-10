package com.jramirez.instamovies.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.jramirez.instamovies.R
import com.jramirez.instamovies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            setUpBottomNavigationBar()
        }
        setSupportActionBar(binding.toolbar)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        navController = findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_movies, R.id.navigation_series
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    private fun setUpBottomNavigationBar() {
        with(binding) {
            navView.selectedItemId = R.id.nav_movies
            val navGraphIds = listOf(R.navigation.nav_movies, R.navigation.nav_series)
            val navController = navView.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = navHostContainer.id,
                intent = intent
            )
            navController.observe(this@MainActivity, { controller ->
                NavigationUI.setupWithNavController(toolbar, controller)
            })

            currentNavController = navController
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return binding.navView.findNavController().navigateUp()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigationBar()
    }
}