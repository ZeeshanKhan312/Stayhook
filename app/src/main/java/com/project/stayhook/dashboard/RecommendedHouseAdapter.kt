package com.project.stayhook.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class RecommendedHouseAdapter (val list:ArrayList<String>,val context: Context?): RecyclerView.Adapter<RecommendedHouseAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val houseImage=itemView.findViewById<ImageView>(R.id.houseImage)
        val houseType=itemView.findViewById<TextView>(R.id.houseType)
        val rating=itemView.findViewById<TextView>(R.id.rating)
        val houseName=itemView.findViewById<TextView>(R.id.houseName)
        val houseLocation=itemView.findViewById<TextView>(R.id.houseLocation)
        val housePrice=itemView.findViewById<TextView>(R.id.housePrice)
        val liked=itemView.findViewById<ImageView>(R.id.liked)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recommendation_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.houseName.text=list.get(position)


        holder.liked.setOnClickListener{
            if(position==position){
                holder.liked.setImageResource(R.drawable.red_heart)
            }
            else{
                holder.liked.setImageResource(R.drawable.heart)
            }
        }
    }
}