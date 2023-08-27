package com.project.stayhook.booking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.applandeo.materialcalendarview.CalendarView
import com.project.stayhook.R

class MoveInActivity : AppCompatActivity() {
    private lateinit var backBtn:TextView
    private lateinit var moveInDate:TextView
    private lateinit var calendarView:CalendarView
    private lateinit var continueBtn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_in)

        backBtn=findViewById(R.id.backBtn)
        moveInDate=findViewById(R.id.moveInDate)
        calendarView=findViewById(R.id.calendarView)
        continueBtn=findViewById(R.id.continueBtn)

        backBtn.setOnClickListener {
            finish()
        }

        continueBtn.setOnClickListener {
            startActivity(Intent(this,BookingSummaryActivity::class.java))
            finish()
        }
    }
}