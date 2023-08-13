package com.project.stayhook.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.project.stayhook.R

class SignInActivity : AppCompatActivity() {
    private lateinit var phoneNumber:TextView
    private lateinit var signInBtn:TextView
    private lateinit var signUpBtn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        phoneNumber=findViewById(R.id.phoneNumber)
        signInBtn=findViewById(R.id.signInBtn)
        signUpBtn=findViewById(R.id.signUpBtn)

        signUpBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        signInBtn.setOnClickListener {
            val number=phoneNumber.text.toString()
            if(number.isNotEmpty()){
                val intent=Intent(this,OtpAuthActivity::class.java)
                intent.putExtra("phoneNumber",number)
                startActivity(intent)
            }
            else if(number.length<10){
                Toast.makeText(this, "Please enter the correct number!!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Please enter the mobile number!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}