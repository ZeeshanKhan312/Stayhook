package com.project.stayhook.booking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.R

class ContractTermAdapter(val list:ArrayList<String>,val context: Context): RecyclerView.Adapter<ContractTermAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val houseCard=itemView.findViewById<RelativeLayout>(R.id.houseCard)
        val minContract=itemView.findViewById<TextView>(R.id.minContract)
        val price=itemView.findViewById<TextView>(R.id.price)
        val monthlyRental=itemView.findViewById<TextView>(R.id.monthlyRental)
        val chargeInfo=itemView.findViewById<TextView>(R.id.chargeInfo)
        val relocationInfo=itemView.findViewById<TextView>(R.id.relocationInfo)
        val upgradeInfo=itemView.findViewById<TextView>(R.id.upgradeInfo)
        val freeTrial=itemView.findViewById<TextView>(R.id.freeTrial)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.contract_term_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.minContract.text=list.get(position)

        holder.houseCard.setOnClickListener{
            holder.houseCard.setBackgroundResource(R.color.gray3)
            ContractTermActivity.setButton(holder.minContract.text.toString())
        }
    }
}