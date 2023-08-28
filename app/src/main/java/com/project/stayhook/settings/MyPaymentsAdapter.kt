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
import com.project.stayhook.booking.PaymentActivity
import com.project.stayhook.common.HouseDescriptionActivity

class MyPaymentsAdapter(val list:ArrayList<String>,val selected: ArrayList<String>,val context: Context):RecyclerView.Adapter<MyPaymentsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomPic=itemView.findViewById<ImageView>(R.id.roomPic)
        val roomDescription=itemView.findViewById<TextView>(R.id.roomDescription)
        val roomLocation=itemView.findViewById<TextView>(R.id.roomLocation)
        val bookingDetails=itemView.findViewById<TextView>(R.id.bookingDetails)
        val bookingPrice=itemView.findViewById<TextView>(R.id.bookingPrice)
        val paymentBtn=itemView.findViewById<TextView>(R.id.paymentBtn)
        val houseCard=itemView.findViewById<RelativeLayout>(R.id.houseCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.payment_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.roomDescription.text=list.get(position)

        if(selected[0]=="pendingPayments"){
            holder.paymentBtn.text="Pay-$ 999"
            holder.bookingDetails.visibility=View.VISIBLE
            holder.bookingPrice.visibility=View.VISIBLE
            holder.paymentBtn.setTextColor(Color.parseColor("#FFFFFF"))
            holder.paymentBtn.setBackgroundResource(R.drawable.rectangle_box)
        }
        else if(selected[0]=="pastPayments"){
            holder.bookingDetails.visibility=View.GONE
            holder.bookingPrice.visibility=View.GONE
            holder.paymentBtn.text="Rent Paid for Aug, 2023"
            holder.paymentBtn.setTextColor(Color.parseColor("#FFFFFF"))
            holder.paymentBtn.setBackgroundResource(R.drawable.grey_box)
        }

        holder.paymentBtn.setOnClickListener {
            if(holder.paymentBtn.text.toString() == "Move Out"){
                context.startActivity(Intent(context,PaymentActivity::class.java))
            }
        }

        holder.houseCard.setOnClickListener{
            context.startActivity(Intent(context, HouseDescriptionActivity::class.java))
        }
    }
}