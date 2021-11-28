package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.authorization.*

class AuthorizationActivity: AppCompatActivity() {
    override fun onBackPressed(){}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.authorization)
        loginButton.setOnClickListener{
            val emailText = mailEditText.text.toString()
            val passwordText = passwordEditText.text.toString()
            val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
            if(isEmailValid and passwordText.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }else if(emailText.isEmpty() and passwordText.isEmpty()){
                val myToast = Toast.makeText(applicationContext, "Fields cannot be empty", Toast.LENGTH_SHORT)
                myToast.show()
            }else if(!isEmailValid){
                val myToast = Toast.makeText(applicationContext, "Please enter your valid email", Toast.LENGTH_SHORT)
                myToast.show()
            }else if(passwordText.isEmpty()){
                val myToast = Toast.makeText(applicationContext, "Password cannot be empty", Toast.LENGTH_SHORT)
                myToast.show()
            }
        }
    }
}