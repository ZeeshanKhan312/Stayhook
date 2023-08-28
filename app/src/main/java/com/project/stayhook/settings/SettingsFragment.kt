package com.project.stayhook.settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.project.stayhook.R

class SettingsFragment : Fragment() {
    private lateinit var myBooking:TextView
    private lateinit var myPayment:TextView
    private lateinit var scheduledVisit:TextView
    private lateinit var moveInAndOut:TextView
    private lateinit var completeProfile:TextView
    private lateinit var uploadDocument:TextView
    private lateinit var resolveProblem:TextView
    private lateinit var faq:TextView
    private lateinit var about:TextView
    private lateinit var signOut:TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        initViews(view)

        myBooking.setOnClickListener {
            startActivity(Intent(this.context,MyBookingsActivity::class.java))
        }

        myPayment.setOnClickListener {
            startActivity(Intent(this.context,MyPaymentsActivity::class.java))
        }

        return view
    }

    fun initViews(view: View){
        myBooking=view.findViewById(R.id.myBooking)
        myPayment=view.findViewById(R.id.myPayment)
        scheduledVisit=view.findViewById(R.id.scheduledVisit)
        moveInAndOut=view.findViewById(R.id.moveInAndOut)
        completeProfile=view.findViewById(R.id.completeProfile)
        uploadDocument=view.findViewById(R.id.uploadDocument)
        resolveProblem=view.findViewById(R.id.resolveProblem)
        faq=view.findViewById(R.id.faq)
        about=view.findViewById(R.id.about)
        signOut=view.findViewById(R.id.myBooking)

    }


}