package com.priambudi19.myinternshiptest

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.priambudi19.myinternshiptest.databinding.ActivityMainBinding
import com.priambudi19.myinternshiptest.galery.viewmodel.GalleryViewModel
import com.priambudi19.myinternshiptest.place.adapter.PlaceAdapter
import com.priambudi19.myinternshiptest.place.view.PlaceFragment
import com.priambudi19.myinternshiptest.place.viewmodel.PlaceViewModel
import com.priambudi19.myinternshiptest.vo.Resource

class MainActivity : AppCompatActivity() {
    private val viewModel: PlaceViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navControler = navHostFragment.navController
        setupActionBarWithNavController(navControler)
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navControler)
    }
    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragment_container).navigateUp()
    }


}