package com.project.stayhook.settings

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R
import com.project.stayhook.account.HousePreviewAdapter
import com.project.stayhook.dashboard.DashboardActivity

class MyBookingsActivity : AppCompatActivity() {
    private lateinit var current:TextView
    private lateinit var past:TextView
    private lateinit var upcoming:TextView
    private lateinit var backBtn:TextView
    private lateinit var bookingsRV:RecyclerView
    val list=ArrayList<String>()
    val selected=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_bookings)

        current=findViewById(R.id.current)
        past=findViewById(R.id.past)
        upcoming=findViewById(R.id.upcoming)
        backBtn=findViewById(R.id.text1)
        bookingsRV=findViewById(R.id.bookingsRV)

        selected.add(0,"current")
        getBookingList(selected)
        val myBookingAdapter= MyBookingAdapter(list,selected,this)
        bookingsRV.layoutManager= LinearLayoutManager(this)
        bookingsRV.adapter=myBookingAdapter

        backBtn.setOnClickListener {
            finish()
        }

        current.setOnClickListener {
            if(selected[0] !="current"){
                current.setTextColor(Color.parseColor("#ffffff"))
                past.setTextColor(Color.parseColor("#FF000000"))
                upcoming.setTextColor(Color.parseColor("#FF000000"))
                current.setBackgroundResource(R.color.colorPrimary)
                past.setBackgroundResource(R.color.white)
                upcoming.setBackgroundResource(R.color.white)
                selected.add(0,"current")

                list.clear()
                getBookingList(selected)
                myBookingAdapter.notifyDataSetChanged()
            }
        }

        past.setOnClickListener {
            if(selected[0]!="past"){
                past.setTextColor(Color.parseColor("#ffffff"))
                current.setTextColor(Color.parseColor("#FF000000"))
                upcoming.setTextColor(Color.parseColor("#FF000000"))
                past.setBackgroundResource(R.color.colorPrimary)
                current.setBackgroundResource(R.color.white)
                upcoming.setBackgroundResource(R.color.white)
                selected.add(0,"past")

                list.clear()
                getBookingList(selected)
                myBookingAdapter.notifyDataSetChanged()
            }
        }

        upcoming.setOnClickListener {
            if(selected[0]!="upcoming"){
                current.setTextColor(Color.parseColor("#FF000000"))
                past.setTextColor(Color.parseColor("#FF000000"))
                upcoming.setTextColor(Color.parseColor("#FFFFFF"))
                current.setBackgroundResource(R.color.white)
                past.setBackgroundResource(R.color.white)
                upcoming.setBackgroundResource(R.color.colorPrimary)

                selected.add(0,"upcoming")
                list.clear()
                getBookingList(selected)
                myBookingAdapter.notifyDataSetChanged()
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
}