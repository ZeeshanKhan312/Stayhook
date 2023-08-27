package com.project.stayhook.settings

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R
import com.project.stayhook.common.HouseDescriptionActivity

class MyBookingAdapter(val list:ArrayList<String>,val selected: ArrayList<String>,val context: Context?): RecyclerView.Adapter<MyBookingAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomPic=itemView.findViewById<ImageView>(R.id.roomPic)
        val roomDescription=itemView.findViewById<TextView>(R.id.roomDescription)
        val roomLocation=itemView.findViewById<TextView>(R.id.roomLocation)
        val bookingDetails=itemView.findViewById<TextView>(R.id.bookingDetails)
        val bookingPrice=itemView.findViewById<TextView>(R.id.bookingPrice)
        val actionBtn=itemView.findViewById<TextView>(R.id.actionBtn)
        val houseCard=itemView.findViewById<RelativeLayout>(R.id.houseCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.booking_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.roomDescription.text=list.get(position)

        if(selected[0]=="current"){
            holder.actionBtn.visibility=View.VISIBLE
            holder.actionBtn.text="Move Out"
            holder.actionBtn.setTextColor(Color.parseColor("#FFFFFF"))
            holder.actionBtn.setBackgroundResource(R.drawable.red_box)
        }
        else if(selected[0]=="past"){
            holder.actionBtn.visibility=View.VISIBLE
            holder.actionBtn.text="Moved Out, March 31,2022"
            holder.actionBtn.setTextColor(Color.parseColor("#FFFFFF"))
            holder.actionBtn.setBackgroundResource(R.drawable.grey_box)
        }
        else{
            holder.actionBtn.visibility=View.GONE
        }

        holder.houseCard.setOnClickListener{
            context?.startActivity(Intent(context, HouseDescriptionActivity::class.java))
        }
    }
}