package com.project.stayhook.common

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R
import com.project.stayhook.dashboard.DashboardActivity

class HouseListActivity : AppCompatActivity() {
    private lateinit var typeFilter:TextView
    private lateinit var recyclerView:RecyclerView
    private lateinit var filterBtn:ImageView

    val list=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_list)

        typeFilter=findViewById(R.id.typeFilter)
        recyclerView=findViewById(R.id.recyclerView)
        filterBtn=findViewById(R.id.filterBtn)

        val houseType=intent.getStringExtra("houseType")
        typeFilter.text = houseType
        val houseListAdapter=HouseListAdapter(list,this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter =houseListAdapter
        getHouseList(houseType)

        houseListAdapter.notifyDataSetChanged()

        typeFilter.setOnClickListener {
            finish()
        }


    }

    private fun getHouseList(houseType: String?) {
        list.add("3 BHK House Available")
        list.add("5 Bedroom Kothi Available")
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
        list.add("3 BHK House Available")
        list.add("5 Bedroom Kothi Available")
    }
}