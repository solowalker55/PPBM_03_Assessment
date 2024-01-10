package com.dioageng.thirdassignmentofppbm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainHome : AppCompatActivity() {

    private var lastBackPressTime: Long = 0
    private val doublePressThreshold: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        setContentView(R.layout.activity_main_home)

        val goToTab = findViewById<CardView>(R.id.tablayout_home)
        goToTab.setOnClickListener{
            val Intent = Intent(this, MainTabLayout::class.java)
            startActivity(Intent)
        }

        val goToBottom = findViewById<CardView>(R.id.bottomsheet_home)
        goToBottom.setOnClickListener{
            val Intent = Intent(this, MainBottomSheet::class.java)
            startActivity(Intent)
        }

        val goToSlide = findViewById<CardView>(R.id.slidetoact_home)
        goToSlide.setOnClickListener{
            val Intent = Intent(this, MainSlideToActButton::class.java)
            startActivity(Intent)
        }

        val goToImage = findViewById<CardView>(R.id.imageslider_home)
        goToImage.setOnClickListener{
            val Intent = Intent(this, MainImageSlider::class.java)
            startActivity(Intent)
        }
    }

    override fun onBackPressed() {
        // Check if it's a double press within the threshold
        if (System.currentTimeMillis() - lastBackPressTime < doublePressThreshold) {
            // Double press detected, exit the app
            finishAffinity()
        } else {
            // Update the last back press time
            lastBackPressTime = System.currentTimeMillis()
            // Show a toast or any other indication for the first press
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
    }
}