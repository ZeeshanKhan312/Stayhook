package com.project.stayhook.booking

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_KEYBOARD
import com.project.stayhook.R
import com.project.stayhook.dashboard.DashboardActivity
import java.text.DateFormat
import java.util.Calendar

class ScheduleVisitActivity : AppCompatActivity() {
    private lateinit var time:TextView
    private lateinit var backBtn:TextView
    private lateinit var scheduleBtn:TextView
    private lateinit var AM:TextView
    private lateinit var PM:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_visit)

        initViews()

        val dialog=Dialog(this)
        dialog.setContentView(R.layout.visit_dialog_layout)
//        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
//            dialog.window.setBackgroundDrawable(getDrawable(R.drawable.))
//        }
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        val homePageBtn:TextView=dialog.findViewById(R.id.homePageBtn)

        backBtn.setOnClickListener {
            finish()
        }

        time.setOnClickListener {
            setTime()
        }

        scheduleBtn.setOnClickListener {
            dialog.show()
        }

        homePageBtn.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this,DashboardActivity::class.java))
            finish()
        }

        AM.setOnClickListener {
            AM.setBackgroundResource(R.drawable.rectangle_box)
            AM.setTextColor(Color.parseColor("#FFFFFF"))

            PM.setBackgroundResource(R.drawable.grey_box)
            PM.setTextColor(Color.parseColor("#000000"))
        }
        PM.setOnClickListener {
            PM.setBackgroundResource(R.drawable.rectangle_box)
            PM.setTextColor(Color.parseColor("#FFFFFF"))

            AM.setBackgroundResource(R.drawable.grey_box)
            AM.setTextColor(Color.parseColor("#000000"))
        }
    }


    fun setTime(){
        val calendar = Calendar.getInstance()
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                // Handle the selected time (hourOfDay and minute) here
                val formattedTime = String.format("%02d:%02d", hour, minute)
                time.text = formattedTime
            },
            currentHour,
            currentMinute,
            false // 24-hour format
        )

        timePickerDialog.show()
    }

    override fun onBackPressed() {
        // Call finish() to close the current activity and return to the previous activity
        finish()
    }

    private fun initViews(){
        time=findViewById(R.id.time)
        backBtn=findViewById(R.id.text1)
        scheduleBtn=findViewById(R.id.scheduleBtn)
        AM=findViewById(R.id.AM)
        PM=findViewById(R.id.PM)

    }
}

