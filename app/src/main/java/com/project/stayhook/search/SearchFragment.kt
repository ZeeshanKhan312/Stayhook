package com.project.stayhook.search

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R
import com.project.stayhook.common.HouseListAdapter


class SearchFragment : Fragment() {
    private lateinit var searchBtn:ImageView
    private lateinit var searchValue:EditText
    private lateinit var nearHouseRV:RecyclerView
    private lateinit var filterBtn:ImageView
    private val list=ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_search, container, false)
        searchBtn=view.findViewById(R.id.searchBtn)
        searchValue=view.findViewById(R.id.searchValue)
        filterBtn=view.findViewById(R.id.filterBtn)
        nearHouseRV=view.findViewById(R.id.nearHouseRV)
        var searchKey:String=""
        searchBtn.setOnClickListener{
            searchKey=searchValue.text.toString()
            if(searchKey.isNotEmpty()){
                val intent=Intent(this.context,SearchListActivity::class.java)
                intent.putExtra("searchKey",searchKey)
                startActivity(intent)
            }
        }

        val dialog= Dialog(requireContext())
        dialog.setContentView(R.layout.filter_dialog_layout)
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        val advanceSearch: TextView =dialog.findViewById(R.id.searchBtn)
        val advanceSearchKey:EditText=dialog.findViewById(R.id.addressSearch)
        filterBtn.setOnClickListener{
            dialog.show()
        }

        advanceSearch.setOnClickListener {
            searchKey=advanceSearchKey.text.toString()
            if(searchKey.isNotEmpty()) {
                dialog.dismiss()
                val intent = Intent(this.context, SearchListActivity::class.java)
                intent.putExtra("searchKey", searchKey)
                startActivity(intent)
            }
        }

        val houseType="Nearby House"
        val houseListAdapter= HouseListAdapter(list,requireContext())
        nearHouseRV.layoutManager= LinearLayoutManager(this.context)
        nearHouseRV.adapter =houseListAdapter
        getHouseList(houseType)


        return view
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