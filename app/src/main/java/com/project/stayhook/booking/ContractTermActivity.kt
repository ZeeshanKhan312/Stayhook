package com.project.stayhook.booking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class ContractTermActivity : AppCompatActivity() {
    private lateinit var backBtn:TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var continueBtn:TextView
    val list=ArrayList<String>()

    companion object {
        @JvmStatic
        fun setButton(text:String) {
            println("jksa dskjnm sldkm sdk,")
//             lateinit var continueBtn:TextView
//             continueBtn.text=text

//            Handler(Looper.getMainLooper()).post {
//                val textView = findViewById<TextView>(R.id.myTextView)
//                textView.text = text
//            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contract_term)

        backBtn=findViewById(R.id.backBtn)
        recyclerView=findViewById(R.id.recyclerView)
        continueBtn=findViewById(R.id.continueBtn)

        val adapter=ContractTermAdapter(list,this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

        getList()

           backBtn.setOnClickListener {
               finish()
           }
            continueBtn.setOnClickListener {
                val intent=Intent(this,SelectRoomActivity::class.java)
//                intent.putExtra("contractTerm",)
                startActivity(intent)
            }
    }

    fun getList(){
        list.clear()
        list.add("Min 3 months")
        list.add("Min 6 months")
        list.add("Min 12 months")
        list.add("Min 18 months")
        list.add("Min 24 months")
    }
}