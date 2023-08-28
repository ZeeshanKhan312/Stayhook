package com.project.stayhook.settings

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.project.stayhook.R
import com.project.stayhook.dashboard.DashboardActivity

class MoveOutActivity : AppCompatActivity() {
    private lateinit var roomDescription:TextView
    private lateinit var roomLocation:TextView
    private lateinit var bookingDetails:TextView
    private lateinit var bookingPrice:TextView
    private lateinit var checkbox:CheckBox
    private lateinit var termsCondition:TextView
    private lateinit var moveOutBtn:TextView
    private lateinit var backBtn:TextView
    private lateinit var roomPic:ImageView
    private lateinit var calendarView:CalendarView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_out)

        initViews()

        backBtn.setOnClickListener {
            finish()
        }

//        calendarView.setOnDayClickListener

        val dialog= Dialog(this)
        dialog.setContentView(R.layout.moveout_dialog_layout)
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        val homePageBtn:TextView=dialog.findViewById(R.id.homePageBtn)
        moveOutBtn.setOnClickListener {
            if(checkbox.isChecked){
                dialog.show()
            }
            else{
                Toast.makeText(this, "Kindly accept our terms and condition!", Toast.LENGTH_SHORT).show()
            }
        }

        homePageBtn.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this,DashboardActivity::class.java))
            finish()
        }

    }

    fun initViews(){
        roomDescription=findViewById(R.id.roomDescription)
        roomLocation=findViewById(R.id.roomLocation)
        bookingDetails=findViewById(R.id.bookingDetails)
        bookingPrice=findViewById(R.id.bookingPrice)
        checkbox=findViewById(R.id.checkbox)
        termsCondition=findViewById(R.id.termsCondition)
        moveOutBtn=findViewById(R.id.moveOutBtn)
        backBtn=findViewById(R.id.backBtn)
        roomPic=findViewById(R.id.roomPic)
        calendarView=findViewById(R.id.calendarView)
    }
}