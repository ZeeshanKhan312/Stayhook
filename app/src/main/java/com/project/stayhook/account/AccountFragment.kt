package com.project.stayhook.account

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class AccountFragment : Fragment() {

    private lateinit var userName:TextView
    private lateinit var email:TextView
    private lateinit var phoneNo:TextView
    private lateinit var applied: TextView
    private lateinit var location:TextView
    private lateinit var liked: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var editBtn:ImageView
    val list=ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_account, container, false)
        userName=view.findViewById(R.id.userName)
        email=view.findViewById(R.id.email)
        phoneNo=view.findViewById(R.id.phoneNo)
        location=view.findViewById(R.id.location)
        applied=view.findViewById(R.id.applied)
        liked=view.findViewById(R.id.liked)
        recyclerView=view.findViewById(R.id.houseRV)
        editBtn=view.findViewById(R.id.editBtn)

        var selected="applied"
        applied()
        val libraryAdapter=HousePreviewAdapter(list,requireContext())
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.adapter=libraryAdapter

        applied.setOnClickListener {
            if(selected!="course"){
                applied.setTextColor(Color.parseColor("#ffffff"))
                liked.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                applied.setBackgroundResource(R.color.colorPrimary)
                liked.setBackgroundResource(R.color.white)
                selected="course"

                list.clear()
                applied()
                libraryAdapter.notifyDataSetChanged()
            }
        }

        liked.setOnClickListener {
            if(selected!="liked"){
                liked.setTextColor(Color.parseColor("#ffffff"))
                applied.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                liked.setBackgroundResource(R.color.colorPrimary)
                applied.setBackgroundResource(R.color.white)
                selected="liked"

                list.clear()
                liked()
                libraryAdapter.notifyDataSetChanged()
            }
        }

        editBtn.setOnClickListener{
            startActivity(Intent(requireContext(),EditProfileActivity::class.java))
        }

        return view
    }

    fun applied() {
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }

    fun liked(){
        list.add("1 Room Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }


}