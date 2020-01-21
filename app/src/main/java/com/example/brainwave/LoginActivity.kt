package com.example.brainwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        supportActionBar!!.hide()

        clickLogin.setOnClickListener {
            if(TextUtils.isEmpty(enterEmail.text.toString()) || TextUtils.isEmpty(enterPass.text.toString()))
                Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()
            else{
                auth.signInWithEmailAndPassword(enterEmail.text.toString(), enterPass.text.toString()).addOnCompleteListener (this, OnCompleteListener { task ->
                    if ( task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }else {
                        Toast.makeText(this,"Incorrect email or password", Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }
        clickRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }



}
