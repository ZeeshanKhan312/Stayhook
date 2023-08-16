package com.project.stayhook.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.stayhook.R
import com.project.stayhook.account.AccountFragment
import com.project.stayhook.search.SearchFragment
import com.project.stayhook.settings.SettingsFragment

class DashboardActivity : AppCompatActivity() {
    lateinit var bottomNavigationBar: com.google.android.material.bottomnavigation.BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        bottomNavigationBar = findViewById(R.id.navigation_bar)

        supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, HomeFragment()).commit()

        bottomNavigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeTab -> {
                    // Replace the fragment or launch the activity for Home
                    supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, HomeFragment()).commit()
                    true
                }
                R.id.searchTab -> {
                    // Replace the fragment or launch the activity for Dashboard
                    supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, SearchFragment()).commit()
                    true
                }
                R.id.settingsTab -> {
                    // Replace the fragment or launch the activity for Notifications
                    supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, SettingsFragment()).commit()
                    true
                }
                R.id.accountTab -> {
                    // Replace the fragment or launch the activity for Notifications
                    supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, AccountFragment()).commit()
                    true
                }
                else -> false
            }
        }

    }
}