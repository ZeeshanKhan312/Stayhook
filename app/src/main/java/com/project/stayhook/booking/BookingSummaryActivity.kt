package com.project.stayhook.booking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.project.stayhook.R

class BookingSummaryActivity : AppCompatActivity() {
    private lateinit var backBtn:TextView
    private lateinit var monthlyRent:TextView
    private lateinit var maintenance:TextView
    private lateinit var monthlyPayable:TextView
    private lateinit var refundableDeposit:TextView
    private lateinit var advancePayment:TextView
    private lateinit var totalPayableNow:TextView
    private lateinit var payBtn:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_summary)

        initViews()

        backBtn.setOnClickListener {
            finish()
        }

        payBtn.setOnClickListener {
            startActivity(Intent(this,PaymentActivity::class.java))
            finish()
        }


    }



    fun initViews(){
        backBtn=findViewById(R.id.backBtn)
        monthlyRent=findViewById(R.id.monthlyRent)
        maintenance=findViewById(R.id.maintenance)
        monthlyPayable=findViewById(R.id.monthlyPayable)
        refundableDeposit=findViewById(R.id.refundableDeposit)
        advancePayment=findViewById(R.id.advancePayment)
        totalPayableNow=findViewById(R.id.totalPayableNow)
        payBtn=findViewById(R.id.payBtn)
    }
}