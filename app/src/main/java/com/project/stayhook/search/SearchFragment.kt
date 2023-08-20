package com.project.stayhook.search

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import com.project.stayhook.R


class SearchFragment : Fragment() {
    private lateinit var searchBtn:ImageView
    private lateinit var searchValue:EditText
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_search, container, false)
        searchBtn=view.findViewById(R.id.searchBtn)
        searchValue=view.findViewById(R.id.searchValue)
        var searchKey:String=""
        searchBtn.setOnClickListener{
            searchKey=searchValue.text.toString()
            if(searchKey.isNotEmpty()){
                val intent=Intent(this.context,SearchListActivity::class.java)
                intent.putExtra("searchKey",searchKey)
                startActivity(intent)
            }
        }
        return view
    }

}