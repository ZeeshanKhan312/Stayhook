package com.project.stayhook.booking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class SelectBedActivity : AppCompatActivity() {
    private lateinit var backBtn: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var continueBtn: TextView
    private val list=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_bed)

        backBtn=findViewById(R.id.backBtn)
        recyclerView=findViewById(R.id.recyclerView)
        continueBtn=findViewById(R.id.continueBtn)

        val adapter=SelectBedAdapter(list,this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

        getData()
        backBtn.setOnClickListener {
            finish()
        }
        continueBtn.setOnClickListener {
            startActivity(Intent(this,MoveInActivity::class.java))
        }
    }
    fun getData(){
        list.clear()
        list.add("Bed 1")
        list.add("Bed 2")
        list.add("Bed 3")
    }
}