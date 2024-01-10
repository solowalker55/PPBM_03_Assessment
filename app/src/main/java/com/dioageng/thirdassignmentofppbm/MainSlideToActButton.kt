package com.dioageng.thirdassignmentofppbm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.ncorti.slidetoact.SlideToActView

class MainSlideToActButton : AppCompatActivity() {
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

        setContentView(R.layout.activity_main_slide_to_act_button)

        val slideToActView: SlideToActView = findViewById(R.id.example)

        slideToActView.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                // Start the new activity here
                val intent = Intent(this@MainSlideToActButton, SecSlideToAct::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        // Handle the back button press
        // For example, navigate to a certain activity
        val intent = Intent(this, MainHome::class.java)
        startActivity(intent)
    }
}