package com.dioageng.thirdassignmentofppbm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainBottomSheet : AppCompatActivity() {
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

        setContentView(R.layout.activity_main_bottom_sheet)

        val show : TextView = findViewById(R.id.show_bottomsheet)

        show.setOnClickListener{
            val view : View = layoutInflater.inflate(R.layout.item_bottomsheet, null)
            val diaolg = BottomSheetDialog(this)
            diaolg.setContentView(view)
            diaolg.show()
        }
    }

    override fun onBackPressed() {
        // Handle the back button press
        // For example, navigate to a certain activity
        val intent = Intent(this, MainHome::class.java)
        startActivity(intent)
    }
}
