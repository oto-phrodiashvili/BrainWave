package com.example.hangmanpro

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref: SharedPreferences = getSharedPreferences("sharedprefs",0)
        forTest.setText(sharedPref.getString("Nickname",null))
        print(sharedPref.getString("Nickname",null))

    }
}
