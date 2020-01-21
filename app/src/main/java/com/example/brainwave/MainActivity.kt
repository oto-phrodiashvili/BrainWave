package com.example.brainwave

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({},600)
        setContentView(R.layout.activity_main)
        val sharedPref: SharedPreferences = getSharedPreferences("sharedprefs",0)
        supportActionBar!!.hide()




    }
}
