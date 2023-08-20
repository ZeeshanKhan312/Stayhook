package com.project.stayhook.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R
import com.project.stayhook.common.HouseListActivity


class HomeFragment : Fragment() {
    private lateinit var location:TextView
    private lateinit var searchValue:EditText
    private lateinit var searchBtn:ImageView
    private lateinit var allRecommendation:TextView
    private lateinit var allRecentlyAdded:TextView

    private lateinit var recommendationRV:RecyclerView
    private lateinit var recentlyAddedRV:RecyclerView

    private lateinit var findFlat:CardView
    private lateinit var findApartment:CardView
    private lateinit var findPrivateRoom:CardView
    private lateinit var findSharedRoom:CardView
    private lateinit var findHouse:CardView
    private lateinit var findVilla:CardView
    private lateinit var findKothi:CardView
    private lateinit var findPG:CardView
    private lateinit var findCoLiving:CardView


    val list=ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        initView(view)

//        location.setText(currAddress)

        val recommendedHouseAdapter=RecommendedHouseAdapter(list,context)
        recommendationRV.layoutManager=LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)
        recommendationRV.adapter=recommendedHouseAdapter
        getRecommendationList()
        recommendedHouseAdapter.notifyDataSetChanged()


        val recentlyAddedAdapter=RecentlyAddedAdapter(list, context)
        recentlyAddedRV.layoutManager=LinearLayoutManager(this.context)
        recentlyAddedRV.adapter=recentlyAddedAdapter
        getRecentlyAddedList()
        recentlyAddedAdapter.notifyDataSetChanged()

        allRecommendation.setOnClickListener {
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Recommendation")
            startActivity(intent)
        }
        allRecentlyAdded.setOnClickListener {
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Recently Added")
            startActivity(intent)
        }



        findFlat.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Flats")
            startActivity(intent)
        }

        findApartment.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Apartment")
            startActivity(intent)
        }
        findPG.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","P.G")
            startActivity(intent)
        }
        findKothi.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Kothi")
            startActivity(intent)
        }
        findHouse.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","House")
            startActivity(intent)
        }
        findCoLiving.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Co-Living")
            startActivity(intent)
        }
        findPrivateRoom.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Private Room")
            startActivity(intent)
        }
        findSharedRoom.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Shared Room")
            startActivity(intent)
        }
        findVilla.setOnClickListener{
            val intent=Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType","Villa")
            startActivity(intent)
        }

        return view
    }

    fun getRecommendationList(){
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }
    fun getRecentlyAddedList(){
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }

    fun initView(view: View) {
        location=view.findViewById(R.id.location)
        searchValue=view.findViewById(R.id.searchValue)
        searchBtn=view.findViewById(R.id.searchBtn)
        allRecommendation=view.findViewById(R.id.allRecommendation)
        allRecentlyAdded=view.findViewById(R.id.allRecentlyAdded)

        recommendationRV=view.findViewById(R.id.recommendationRV)
        recentlyAddedRV=view.findViewById(R.id.recentlyAddedRV)

        findFlat=view.findViewById(R.id.findFlat)
        findApartment=view.findViewById(R.id.findApartment)
        findPrivateRoom=view.findViewById(R.id.findPrivateRoom)
        findSharedRoom=view.findViewById(R.id.findSharedRoom)
        findHouse=view.findViewById(R.id.findHouse)
        findVilla=view.findViewById(R.id.findVilla)
        findKothi=view.findViewById(R.id.findKothi)
        findPG=view.findViewById(R.id.findPG)
        findCoLiving=view.findViewById(R.id.findCoLiving)
    }

}