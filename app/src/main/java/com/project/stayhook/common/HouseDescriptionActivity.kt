package com.project.stayhook.common

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.project.stayhook.R
import com.project.stayhook.booking.ContractTermActivity
import com.project.stayhook.booking.ScheduleVisitActivity

class HouseDescriptionActivity : AppCompatActivity() {
    private lateinit var backBtn:ImageView
    private lateinit var favtBtn:ImageView
    private lateinit var scheduledVisit:TextView
    private lateinit var reserveBtn:TextView
    private lateinit var housePrice:TextView
    private lateinit var houseName:TextView
    private lateinit var houseLocation:TextView
    private lateinit var houseCategory:TextView
    private lateinit var houseRating:TextView
    private lateinit var managerName:TextView
    private lateinit var managerPosition:TextView
    private lateinit var contactManager:TextView
    private lateinit var contractTerm:TextView
    private lateinit var bathroomCount:TextView
    private lateinit var bedsCount:TextView
    private lateinit var areaCount:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_description)

        initViews()

        backBtn.setOnClickListener{
            finish()
        }

        favtBtn.setOnClickListener{
            if(1==1){
                favtBtn.setImageResource(R.drawable.red_heart)
            }
            else{
                favtBtn.setImageResource(R.drawable.heart)
            }
        }

        scheduledVisit.setOnClickListener {
            startActivity(Intent(this,ScheduleVisitActivity::class.java))
        }

        reserveBtn.setOnClickListener {
            startActivity(Intent(this,ContractTermActivity::class.java))
        }

    }

    override fun onBackPressed() {
        // Call finish() to close the current activity and return to the previous activity
        finish()
    }

    fun initViews(){
        backBtn=findViewById(R.id.backBtn)
        favtBtn=findViewById(R.id.favtBtn)
        scheduledVisit=findViewById(R.id.scheduledVisit)
        reserveBtn=findViewById(R.id.reserveBtn)
        housePrice=findViewById(R.id.housePrice)
        houseName=findViewById(R.id.houseName)
        houseLocation=findViewById(R.id.houseLocation)
        houseCategory=findViewById(R.id.houseCategory)
        houseRating=findViewById(R.id.houseRating)
        managerName=findViewById(R.id.managerName)
        managerPosition=findViewById(R.id.managerPosition)
        contactManager=findViewById(R.id.contactManager)
        contractTerm=findViewById(R.id.contractTerm)
        bathroomCount=findViewById(R.id.bathroomCount)
        bedsCount=findViewById(R.id.bedsCount)
        areaCount=findViewById(R.id.areaCount)
    }
}