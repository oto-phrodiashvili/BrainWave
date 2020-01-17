package com.example.hangmanpro

import android.app.ActionBar
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {



    private  lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref: SharedPreferences = getSharedPreferences("sharedprefs",0)

        if (sharedPref.getBoolean("User Logged In", false)){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        val db: FirebaseDatabase = FirebaseDatabase.getInstance()
        val dbRef: DatabaseReference = db.getReference("users")


        mAuth = FirebaseAuth.getInstance()
        btnRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val email: String = input_email.text.toString()
            val password: String = input_password.text.toString()

            dbRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot!!.exists()){
                        for (i in dataSnapshot.children){
                            val user = i.getValue(User::class.java)!!
                            if(user.email == email){
                                val nickname = user.nickname
                                sharedPref.edit().putString("Nickname",nickname).apply()
                                break
                            }
                        }
                    }


                }
                override fun onCancelled(error: DatabaseError) {

                }
            })

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
            {Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()}
            else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener {task ->
                    if (task.isSuccessful) {
                        sharedPref.edit().putBoolean("User Logged In", true).apply()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Email or password is incorrect.",Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }
}
