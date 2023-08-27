package com.project.stayhook.booking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class SelectRoomActivity : AppCompatActivity() {
    private lateinit var contractTerm:TextView
    private lateinit var backBtn: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var continueBtn: TextView
    val list=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_room)

        contractTerm=findViewById(R.id.contractTerm)
        backBtn=findViewById(R.id.backBtn)
        recyclerView=findViewById(R.id.recyclerView)
        continueBtn=findViewById(R.id.continueBtn)

//        contractTerm.text=intent.getStringExtra("contractTerm")

        val adapter=SelectRoomAdapter(list, this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

        getData()

        backBtn.setOnClickListener {
            finish()
        }
        continueBtn.setOnClickListener {
            startActivity(Intent(this,SelectBedActivity::class.java))
            finish()
        }
    }

    fun getData(){
        list.clear()
        list.add("Room 1")
        list.add("Room 2")
        list.add("Room 3")
        list.add("Room 4")
    }
}