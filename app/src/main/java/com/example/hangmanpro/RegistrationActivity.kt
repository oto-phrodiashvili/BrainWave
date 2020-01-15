package com.example.hangmanpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance()
        dbRef = db.getReference("users")



        btnRegister.setOnClickListener {
            val nickname: String = inputNickname.text.toString()
            val email: String = emailRegister.text.toString()
            val password: String = password1.text.toString()
            val passwoordConfirm: String = password2.text.toString()

            if(TextUtils.isEmpty(nickname)||TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(passwoordConfirm))
                {Toast.makeText(this, "Fill empty fields", Toast.LENGTH_SHORT).show()}

            else if (password.length <= 7 )
            {Toast.makeText(this, "Password must consist of at least 8 letters", Toast.LENGTH_LONG).show()}

            else if (passwoordConfirm != password) {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            }

            else{
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        val userId = dbRef.push().key
                        val user = User(userId!!, email, nickname)
                        dbRef.child(userId).setValue(user).addOnCompleteListener{
                            Toast.makeText(this,"Registration Success!",Toast.LENGTH_LONG)
                        }
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this, "Something went wrong",Toast.LENGTH_SHORT).show()

                    }


                })
            }



        }

    }
}
