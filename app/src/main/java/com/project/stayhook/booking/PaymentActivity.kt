package com.project.stayhook.booking

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.project.stayhook.R
import com.project.stayhook.dashboard.DashboardActivity

class PaymentActivity : AppCompatActivity() {
    private lateinit var backBtn:TextView
    private lateinit var paymentCard:RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        backBtn=findViewById(R.id.backBtn)
        paymentCard=findViewById(R.id.paymentCard)

        backBtn.setOnClickListener {
            finish()
        }

        val dialog= Dialog(this)
        dialog.setContentView(R.layout.booked_dialog_layout)
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        val homePageBtn:TextView=dialog.findViewById(R.id.homePageBtn)
        paymentCard.setOnClickListener{
            dialog.show()
        }

        homePageBtn.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
    }
}