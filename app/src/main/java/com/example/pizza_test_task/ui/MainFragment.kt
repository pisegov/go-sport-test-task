package com.example.pizza_test_task.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pizza_test_task.R
import com.example.pizza_test_task.databinding.FragmentMainBinding
import com.example.pizza_test_task.util.viewBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController =
            binding.navHostFragmentContentMain.getFragment<NavHostFragment>()
                .navController
        binding.mainBottomNavigationView.setupWithNavController(navController)

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, _ ->
            WindowInsetsCompat.CONSUMED
        }
    }
}