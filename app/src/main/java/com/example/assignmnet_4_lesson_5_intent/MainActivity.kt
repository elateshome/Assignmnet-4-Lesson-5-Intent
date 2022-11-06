package com.example.assignmnet_4_lesson_5_intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val users = mutableListOf<User>(User("elias", "teshome", "elias@gmail.com", "elias"),
        User("zekarias", "teshome", "zekarias@gmail.com", "zekarias"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                if(result.data?.hasExtra("user")!!){
                    users.add(result.data?.getSerializableExtra("user") as User)
                }
            }
        }


        btn_create.setOnClickListener(){
            val reg = Intent(this, Register::class.java)
            launcher.launch(reg)
        }

        signin_btn.setOnClickListener(){

            val email = findViewById<EditText>(R.id.email).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()

            val user = userInfo(email, password)

            if(user != null){
                val intent = Intent(this, ShoppingCategoryActivity::class.java)
                intent.putExtra("username",user.userName )


                startActivity(intent)
            }
        }

        forget_btn.setOnClickListener(){
            val userEmail = email.text.trim().toString()
            val user = getUserName(userEmail)

            if(user != null){
                var to = arrayOf(userEmail)
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT, "Sending forgotten password")
                intent.putExtra(Intent.EXTRA_EMAIL, to)
                intent.putExtra(Intent.EXTRA_TEXT, user.password)

                startActivity(intent)
            }

        }

    }


    private fun userInfo(username: String, password: String): User?{
        var userInfo: User? = null

        for (user in users){
            if(user.userName == username && user.password == password){
                userInfo = user
            }
        }

        return userInfo
    }


    private fun getUserName(userName: String?): User?{

        var knownUsers: User? = null

        for(user in users){
            if(user.userName == userName){
                knownUsers = user
            }
        }

        return knownUsers
    }



}