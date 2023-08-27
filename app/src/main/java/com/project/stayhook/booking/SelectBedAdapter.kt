package com.project.stayhook.booking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class SelectBedAdapter(val list:ArrayList<String>,val context: Context): RecyclerView.Adapter<SelectBedAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val houseCard=itemView.findViewById<RelativeLayout>(R.id.houseCard)
        val bedNo=itemView.findViewById<TextView>(R.id.bedNo)
        val price=itemView.findViewById<TextView>(R.id.price)
        val attachedStuffs=itemView.findViewById<TextView>(R.id.attachedStuffs)
        val soldOut=itemView.findViewById<TextView>(R.id.soldOut)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.bed_booking_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bedNo.text=list.get(position)
        holder.soldOut.visibility=View.GONE

//        if(){ //if the room is sold out
//            holder.soldOut.visibility=View.VISIBLE
//            holder.houseCard.setBackgroundResource(R.color.white)
//        }

        holder.houseCard.setOnClickListener{
            holder.houseCard.setBackgroundResource(R.color.gray3)
//            ContractTermActivity.setButton(holder.bedNo.text.toString())
        }
    }
}