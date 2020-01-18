package com.example.hangmanpro

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.hangmanpro.com.example.hangmanpro.Challenge
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_challenge.*

class CreateChallengeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_challenge)
        val fb: FirebaseDatabase = FirebaseDatabase.getInstance()
        val sharedPrefs: SharedPreferences = getSharedPreferences("sharedprefs",0)
        title = sharedPrefs.getString("Nickname",null)
        val fbDab: DatabaseReference = fb.getReference("challenges")


        finishButton.setOnClickListener {
            val wordToPush = word.text.toString().toLowerCase()
            val descToPush = description.text.toString()
            val nicknameToPush = sharedPrefs.getString("Nickname",null)
            if(TextUtils.isEmpty(wordToPush) || TextUtils.isEmpty(descToPush)){
                Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show()}
            else if(wordToPush.length < 3 || wordToPush.length > 10){
                Toast.makeText(this,"Word length must be between 3 and 10 characters",Toast.LENGTH_SHORT).show()}
            else if (descToPush.length < 10){
                Toast.makeText(this,"Description too short",Toast.LENGTH_SHORT).show()}
            else{
                val challenge = Challenge(
                    nicknameToPush!!,
                    wordToPush,
                    descToPush
                )
                fbDab.child(nicknameToPush).setValue(challenge).addOnCompleteListener{
                    finish()
                    Toast.makeText(this,"Success!",Toast.LENGTH_LONG).show()
                }

            }

        }
    }
}
