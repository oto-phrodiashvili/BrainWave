package com.example.hangmanpro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*


class LoginActivity : AppCompatActivity() {



    private  lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
        btnRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val email: String = input_email.text.toString()
            val password: String = input_password.text.toString()
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
            {Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()}
            else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener {task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Something went wrong!",Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }
}
