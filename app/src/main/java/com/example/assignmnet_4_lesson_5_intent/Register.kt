package com.example.assignmnet_4_lesson_5_intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_account.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)


        btn_register.setOnClickListener{
            val firstName = first_name.text.trim().toString()
            val lastName = last_name.text.trim().toString()
            val email = registration_email.text.trim().toString()
            val password = password.text.trim().toString()


            if((firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())){

                Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
                val user = User(firstName, lastName, email, password)

                 val intent = Intent()
                intent.putExtra("user", user)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }



}