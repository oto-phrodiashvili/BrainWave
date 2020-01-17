package com.example.hangmanpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_challenges.*
import org.w3c.dom.Text

class ChallengesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenges)
        val customTextView = TextView(this)
        scrollChallenges.addView(customTextView)
    }
}
