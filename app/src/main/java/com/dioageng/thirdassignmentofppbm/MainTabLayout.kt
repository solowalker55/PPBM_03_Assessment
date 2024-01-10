package com.dioageng.thirdassignmentofppbm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.dioageng.thirdassignmentofppbm.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainTabLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the activity to run in immersive mode
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )

        // Hide the status bar
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main_tab_layout)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2){tab,position->
            when (position){
                0->{
                    tab.text = "First"
                }
                1->{
                    tab.text = "Second"
                }
                2->{
                    tab.text = "Third"
                }
                3->{
                    tab.text = "Fourth"
                }
            }
        }.attach()
    }

    override fun onBackPressed() {
        // Handle the back button press
        // For example, navigate to a certain activity
        val intent = Intent(this, MainHome::class.java)
        startActivity(intent)
    }
}