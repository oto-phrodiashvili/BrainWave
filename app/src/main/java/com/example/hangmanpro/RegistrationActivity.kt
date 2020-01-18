package com.example.hangmanpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.hangmanpro.com.example.hangmanpro.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        supportActionBar!!.hide()
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance()
        dbRef = db.getReference("users")

        var list: MutableList<String> = mutableListOf()

        dbRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot!!.exists()){
                    for (i in dataSnapshot.children){
                        list.add(i.child("nickname").value.toString())
                    }
                }


            }
            override fun onCancelled(error: DatabaseError) {

            }
        })


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
            else if (nickname.length < 3 || nickname.length > 10 ) {
                Toast.makeText(this, "Nickname length must be between 3 and 10 characters", Toast.LENGTH_SHORT).show()
            }
            else if ("@" in nickname || "." in nickname){
                Toast.makeText(this, "Nickname cannot contain special characters '@' and '.'",Toast.LENGTH_LONG).show()
            }
            else if (nickname in list){
                Toast.makeText(this, "Nickname already exists", Toast.LENGTH_LONG).show()
            }
            else{
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        val user =
                            User(
                                nickname,
                                email
                            )
                        dbRef.child(nickname).setValue(user).addOnCompleteListener{
                            finish()
                            Toast.makeText(this,"Registration Success!",Toast.LENGTH_LONG)
                        }



                    }
                    else {
                        Toast.makeText(this, "Email already registered or invalid input",Toast.LENGTH_SHORT).show()

                    }


                })
            }



        }

    }
}
