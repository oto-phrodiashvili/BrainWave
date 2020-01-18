package com.example.hangmanpro

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.hangmanpro.com.example.hangmanpro.Challenge
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_challenges.*
import org.w3c.dom.Text

class ChallengesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenges)
        val sharedPref: SharedPreferences = getSharedPreferences("sharedprefs",0)
        title = sharedPref.getString("Nickname",null)
        val listOfChallenges: MutableList<Challenge> = mutableListOf()
        val db: FirebaseDatabase = FirebaseDatabase.getInstance()
        val chsRef: DatabaseReference = db.getReference("challenges")

        chsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot!!.exists()){
                    for (i in dataSnapshot.children){
                        val challenge = i.getValue(Challenge::class.java)
                        listOfChallenges.add(challenge!!)
                    }
                }
            }override fun onCancelled(error: DatabaseError) {
            }
        })


        searchChallengeButton.setOnClickListener {
            val nickname = searchChallenge.text.toString()
            var boolean = false
            for (i in listOfChallenges){
                if(i.nickname == nickname){
                    boolean = true
                    sharedPref.edit().putString("ChallengerNickname",i.nickname).apply()
                    sharedPref.edit().putString("ChallengerWord",i.word).apply()
                    sharedPref.edit().putString("ChallengerDescription",i.description).apply()
                    intent = Intent(this,GameActivity::class.java)
                    searchChallenge.setText("")
                    startActivity(intent)
                    break
                }
            }
            if (boolean == false)
                Toast.makeText(this,"Challenge not found!",Toast.LENGTH_SHORT).show()

        }







    }

    }

