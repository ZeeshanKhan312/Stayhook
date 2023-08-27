package com.project.stayhook.search

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R
import com.project.stayhook.common.HouseListAdapter
import com.project.stayhook.dashboard.DashboardActivity

class SearchListActivity : AppCompatActivity() {
    private lateinit var searchKey: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var filterBtn:ImageView

    val list=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        searchKey=findViewById(R.id.searchKey)
        recyclerView=findViewById(R.id.recyclerView)
        filterBtn=findViewById(R.id.filterBtn)

        val houseType=intent.getStringExtra("searchKey")
        searchKey.setText(houseType)
        val houseListAdapter= HouseListAdapter(list,this)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter =houseListAdapter
        getHouseList(houseType)

        houseListAdapter.notifyDataSetChanged()

        searchKey.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        val dialog= Dialog(this)
        dialog.setContentView(R.layout.filter_dialog_layout)
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        val advanceSearch: TextView =dialog.findViewById(R.id.searchBtn)
        val advanceSearchKey: EditText =dialog.findViewById(R.id.addressSearch)
        filterBtn.setOnClickListener{
            dialog.show()
        }

        advanceSearch.setOnClickListener {
            val searchKey=advanceSearchKey.text.toString()
            if(searchKey.isNotEmpty()) {
                dialog.dismiss()
                val intent = Intent(this, SearchListActivity::class.java)
                intent.putExtra("searchKey", searchKey)
                startActivity(intent)
            }
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