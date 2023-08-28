package com.project.stayhook.settings

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class MyPaymentsActivity : AppCompatActivity() {

    private lateinit var backBtn:TextView
    private lateinit var pendingPayments:TextView
    private lateinit var pastPayments:TextView
    private lateinit var paymentsRV:RecyclerView
    val list=ArrayList<String>()
    val selected=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_payments)

        initViews()
        selected.add(0,"pendingPayments")
        getBookingList(selected)
        val myPaymentsAdapter= MyPaymentsAdapter(list,selected,this)
        paymentsRV.layoutManager= LinearLayoutManager(this)
        paymentsRV.adapter=myPaymentsAdapter


        backBtn.setOnClickListener {
            finish()
        }

        pendingPayments.setOnClickListener {
            if(selected[0] !="pendingPayments"){
                pendingPayments.setTextColor(Color.parseColor("#ffffff"))
                pastPayments.setTextColor(Color.parseColor("#FF000000"))
                pendingPayments.setBackgroundResource(R.color.colorPrimary)
                pastPayments.setBackgroundResource(R.color.white)
                selected.add(0,"pendingPayments")

                list.clear()
                getBookingList(selected)
                myPaymentsAdapter.notifyDataSetChanged()
            }
        }

        pastPayments.setOnClickListener {
            if(selected[0]!="pastPayments"){
                pastPayments.setTextColor(Color.parseColor("#ffffff"))
                pendingPayments.setTextColor(Color.parseColor("#FF000000"))
                pastPayments.setBackgroundResource(R.color.colorPrimary)
                pendingPayments.setBackgroundResource(R.color.white)
                selected.add(0,"pastPayments")

                list.clear()
                getBookingList(selected)
                myPaymentsAdapter.notifyDataSetChanged()
            }
        }
    }

    fun getBookingList(selected: ArrayList<String>) {
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }

    fun initViews(){
        backBtn=findViewById(R.id.backBtn)
        pendingPayments=findViewById(R.id.pendingPayments)
        pastPayments=findViewById(R.id.pastPayments)
        paymentsRV=findViewById(R.id.paymentsRV)
    }
}