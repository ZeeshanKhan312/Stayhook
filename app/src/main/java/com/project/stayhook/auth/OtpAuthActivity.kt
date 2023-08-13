package com.project.stayhook.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.size
import com.project.stayhook.R
import com.project.stayhook.location.LocationPermissionActivity
import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView

class OtpAuthActivity : AppCompatActivity() {
    private lateinit var number:TextView
    private lateinit var otpTextView: OtpTextView
    private lateinit var verifyBtn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_auth)
        number=findViewById(R.id.number)
        otpTextView=findViewById(R.id.otpView)
        verifyBtn=findViewById(R.id.verifyBtn)

        number.text=Intent.getIntentOld("phoneNumber").toString()

        otpTextView.requestFocusOTP()
        otpTextView.otpListener= object : OTPListener {
            override fun onInteractionListener() {}

            override fun onOTPComplete(otp: String?) {
                if(otp?.length!!.equals(4)) {
                    startActivity(Intent(this@OtpAuthActivity, LocationPermissionActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@OtpAuthActivity, "Incorrect otp", Toast.LENGTH_LONG).show()
                }
            }
        }

        verifyBtn.setOnClickListener{
            if(otpTextView.size==4){
                startActivity(Intent(this@OtpAuthActivity, LocationPermissionActivity::class.java))
                finish()
            }
            else
                Toast.makeText(this@OtpAuthActivity, "Enter the correct OTP!!", Toast.LENGTH_SHORT).show()
        }
    }
}