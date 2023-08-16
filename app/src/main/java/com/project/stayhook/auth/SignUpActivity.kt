package com.project.stayhook.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.project.stayhook.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var fullName:TextView
    private lateinit var phoneNumber:TextView
    private lateinit var signUpBtn:TextView
    private lateinit var signInBtn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        fullName=findViewById(R.id.fullName)
        phoneNumber=findViewById(R.id.phoneNumber)
        signUpBtn=findViewById(R.id.signUpBtn)
        signInBtn=findViewById(R.id.signInBtn)

        signInBtn.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        }

        signUpBtn.setOnClickListener {
            val name:String=fullName.text.toString()
            val number:String=phoneNumber.text.toString()
            if(name.isNotEmpty() && number.isNotEmpty()){
                val intent=Intent(this,OtpAuthActivity::class.java)
                intent.putExtra("phoneNumber",number)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Please enter all the required Details!!", Toast.LENGTH_SHORT).show()
            }
        }


    }
}