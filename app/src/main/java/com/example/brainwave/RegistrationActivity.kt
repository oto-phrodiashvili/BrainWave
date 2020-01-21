package com.example.brainwave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.brainwave.com.example.hangmanpro.User
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
                        list.add(i.child("username").value.toString())
                    }
                }


            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        clickBackToLogin.setOnClickListener {
            finish()
        }


        clickRegisterConfirm.setOnClickListener {
            val username: String = enterUsernameReg.text.toString()
            val email: String = enterEmailReg.text.toString()
            val password: String = enterPassReg.text.toString()


            if(TextUtils.isEmpty(username)||TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {Toast.makeText(this, "Fill empty fields", Toast.LENGTH_SHORT).show()}

            else if (password.length <= 7 )
            {Toast.makeText(this, "Password must consist of at least 8 letters", Toast.LENGTH_LONG).show()}

            else if (username.length < 3 || username.length > 10 ) {
                Toast.makeText(this, "Username length must be between 3 and 10 characters", Toast.LENGTH_SHORT).show()
            }
            else if ("@" in username || "." in username){
                Toast.makeText(this, "Username cannot contain special characters '@' and '.'",Toast.LENGTH_LONG).show()
            }
            else if (username in list){
                Toast.makeText(this, "Username already exists", Toast.LENGTH_LONG).show()
            }
            else{
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        val user =
                            User(
                                username,
                                email
                            )
                        dbRef.child(username).setValue(user).addOnCompleteListener{
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
