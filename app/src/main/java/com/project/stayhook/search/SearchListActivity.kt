package com.project.stayhook.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R
import com.project.stayhook.common.HouseListAdapter
import com.project.stayhook.dashboard.DashboardActivity

class SearchListActivity : AppCompatActivity() {
    private lateinit var searchKey: TextView
    private lateinit var recyclerView: RecyclerView

    val list=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        searchKey=findViewById(R.id.searchKey)
        recyclerView=findViewById(R.id.recyclerView)

        val houseType=intent.getStringExtra("searchKey")
        searchKey.setText(houseType)
        val houseListAdapter= HouseListAdapter(list,applicationContext)
        recyclerView.layoutManager= LinearLayoutManager(this.applicationContext)
        recyclerView.adapter =houseListAdapter
        getHouseList(houseType)

        houseListAdapter.notifyDataSetChanged()

        searchKey.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
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