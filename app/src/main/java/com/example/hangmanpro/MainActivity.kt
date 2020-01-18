package com.example.hangmanpro

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({},600)
        setContentView(R.layout.activity_main)
        val sharedPref: SharedPreferences = getSharedPreferences("sharedprefs",0)
        title = sharedPref.getString("Nickname",null)


        btnChallenges.setOnClickListener{
            val intent = Intent(this, ChallengesActivity::class.java)
            startActivity(intent)
        }
        btnCreateChallenge.setOnClickListener{

            val intent = Intent(this, CreateChallengeActivity::class.java)
            startActivity(intent)
        }


    }
}
